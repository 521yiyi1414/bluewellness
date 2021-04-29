package com.adafruit.bluefruit.le.connect.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;
import com.adafruit.bluefruit.le.connect.R;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


// based on: https://www.bignerdranch.com/blog/splash-screens-the-right-way/
public class SplashActivity extends AppCompatActivity {

    private Disposable disposable;
    private static int START_MAIN = 100;
    private static int START_DB_UPGRADE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    void goToMainActivity() {

        disposable = Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
//            _Dose dose = DataBaseApi.getInstance().setBoxStore().setDoseBox().queryDoseById(1);
//            if (dose != null && dose.timeL == 0) {
//                emitter.onNext(START_DB_UPGRADE);
//            }else {
//                for (int i = 0; i < 1 ; i++) {
//                    SystemClock.sleep(1000);
//                }
//                emitter.onNext(START_MAIN);
//            }
            emitter.onNext(START_MAIN);
        }, BackpressureStrategy.ERROR)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread()).subscribe(integer -> {
                    if (integer == START_MAIN) {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        //overridePendingTransition(R.anim.splash_anim_in , R.anim.splash_anim_out);
                        this.finish();
                    }else {
//                        Intent intent = new Intent(this, DataBaseUpgradeActivity.class);
//                        startActivity(intent);
//                        //overridePendingTransition(R.anim.splash_anim_in , R.anim.splash_anim_out);
//                        this.finish();
                    }
                });

    }
}
