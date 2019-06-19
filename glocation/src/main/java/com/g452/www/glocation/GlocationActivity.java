package com.g452.www.glocation;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.g452.www.glocation.utils.LocationUtils;
import com.g452.www.glocation.utils.PermissionUtils;

public class GlocationActivity extends AppCompatActivity {

    private String longitude;
    private String latitude;
    private TextView text2;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glocation);

        initPermissonUtils();

    }

    private void initPermissonUtils() {
        PermissionUtils.permission(this, new PermissionUtils.PermissionListener() {
            @Override
            public void success() {
                text2 = (TextView) findViewById(R.id.text2);
                getlongitude();
                findViewById(R.id.bt_dy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getlongitude();
                    }
                });
            }

            @Override
            public void fial() {
                Toast.makeText(GlocationActivity.this, "没有权限无法使用~", Toast.LENGTH_LONG).show();
            }
        });
    }

    //获取经纬度
    private void getlongitude() {
//        Location location = LocationUtils.getInstance(MainActivity.this).showLocation();
        LocationUtils locationUtils = new LocationUtils(GlocationActivity.this);
        Location location = locationUtils.showLocation();
        if (location != null) {
            longitude = String.valueOf(location.getLatitude());
            latitude = String.valueOf(location.getLongitude());
            address = locationUtils.getAddress(location.getLatitude(), location.getLongitude());
            Log.i("经纬度", "纬度" + latitude + "经度" + longitude + "地址信息" + address);
            text2.setText("纬度" + latitude + "经度" + longitude);
        }
    }


}

