package com.quickblox.qmunicate.qb;

import android.support.v4.app.FragmentActivity;

import com.quickblox.module.users.QBUsers;
import com.quickblox.qmunicate.R;
import com.quickblox.qmunicate.core.concurrency.BaseProgressTask;
import com.quickblox.qmunicate.ui.utils.DialogUtils;

public class QBResetPasswordTask extends BaseProgressTask<String, Void, Void> {

    public QBResetPasswordTask(FragmentActivity activity) {
        super(activity);
    }

    @Override
    public Void performInBackground(String... params) throws Exception {
        String email = params[0];

        QBUsers.resetPassword(email);
        return null;
    }

    @Override
    public void onResult(Void aVoid) {
        super.onResult(aVoid);
        final FragmentActivity activity = activityRef.get();
        if (isActivityAlive()) {
            DialogUtils.show(activity, activity.getString(R.string.dlg_check_email));
        }
    }
}