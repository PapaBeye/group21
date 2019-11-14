package edu.vcu.beyep.group21test;

import android.os.Build;

import androidx.annotation.RequiresApi;

interface SeverInterface {
    @RequiresApi(api = Build.VERSION_CODES.N)
    void main();
}
