package com.g452.www.glocation.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.List;

public class PermissionUtils {
 
    public static void permission(final Context context, final PermissionListener listener) {
        AndPermission.with(context)
                .permission(Permission.ACCESS_COARSE_LOCATION,Permission.ACCESS_FINE_LOCATION)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        listener.success();
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        listener.fial();
                        Uri packageURI = Uri.parse("package:" + context.getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(context, "请在设置中设置定位权限~", Toast.LENGTH_LONG).show();
                    }
                }).start();
    }

    public interface PermissionListener {
        void success();
        void fial();
    }
}