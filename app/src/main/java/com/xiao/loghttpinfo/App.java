package com.xiao.loghttpinfo;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by XiaoJianjun on 2017/1/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setLoggerInit();
    }

    /**
     * 调试日志打印
     * 初始化Looger工具
     */
    private void setLoggerInit(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // 是否打印线程号,默认true
                .methodCount(5)         // 展示几个方法数,默认2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) //是否更换打印输出,默认为logcat
                .tag("doctor")   // 全局的tag
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
