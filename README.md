# GlocationUtils
原生api定位获取坐标
一、集成步骤 1、项目的build中添加

    allprojects { repositories { …… …… maven { url 'https://jitpack.io' } } }

2、主moudel的build中添加

    implementation 'com.github.G452:GlocationUtils:0.0.1'
    implementation 'com.github.G452:GlocationUtils:0.0.2'//AndroidX用户   
 

3、点击Sync Now刷新编译

二、使用步骤

1、需要动态获取权限

2、经纬度获取方法

    //获取经纬度
    private void getlongitude() {
        LocationUtils locationUtils = new LocationUtils(MainActivity.this);
        Location location = locationUtils.showLocation();
        if (location != null) {
            //获取经纬度
            longitude = String.valueOf(location.getLatitude());
            latitude = String.valueOf(location.getLongitude());
            //通过经纬度获取详细地址
            address = locationUtils.getAddress(location.getLatitude(), location.getLongitude());
            Log.i("经纬度", "纬度" + latitude + "经度" + longitude + "地址信息" + address);
            textView.setText("纬度" + latitude + "经度" + longitude);
        }
    }
