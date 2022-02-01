import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class svm
  extends Handler
{
  boolean isDestroyed;
  
  svm(svi paramsvi) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((!(paramMessage.obj instanceof Bitmap)) || (this.isDestroyed));
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage.isRecycled());
          paramMessage = jqg.scaleBitmap(paramMessage, (int)(34.0F * this.this$0.mDensity));
        } while (this.this$0.ds == null);
        localObject = (aqzv)this.this$0.ds.get();
        if ((localObject != null) && ((localObject instanceof ardm.o))) {
          ((ardm.o)localObject).QK();
        }
        this.this$0.qJ.setVisibility(0);
        this.this$0.oN.setImageBitmap(paramMessage);
        if ((this.this$0.activity instanceof aqzs))
        {
          paramMessage = ((aqzs)this.this$0.activity).c();
          if ((paramMessage != null) && (paramMessage.a.Jv != null))
          {
            paramMessage.a.Jv.findViewById(2131366728).setVisibility(8);
            paramMessage.a.Jv.findViewById(2131366729).setVisibility(0);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(svi.TAG, 2, "QQBrowserActivity VISIBLE -----------------------");
      return;
    } while ((!(paramMessage.obj instanceof Bitmap)) || (this.isDestroyed) || (this.this$0.a == null) || (this.this$0.a.androidInfo == null) || (TextUtils.isEmpty(this.this$0.a.androidInfo.packName.get())));
    Object localObject = this.this$0.a.androidInfo;
    if (aqiz.isAppInstalled(this.this$0.mContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
      this.this$0.Ba.setText(this.this$0.mContext.getResources().getString(2131690407));
    }
    for (;;)
    {
      this.this$0.AZ.setText(String.format(this.this$0.mContext.getResources().getString(2131690408), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        break;
      }
      paramMessage = jqg.scaleBitmap(paramMessage, (int)(30.0F * this.this$0.mDensity));
      this.this$0.fA.setVisibility(0);
      this.this$0.oP.setImageBitmap(paramMessage);
      aryb.a().d(this.this$0.uin, String.valueOf(aqgb.X(this.this$0.DF)), "ANDROIDQQ.SHAREBAR", "100", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(svi.TAG, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
      return;
      this.this$0.Ba.setText(this.this$0.mContext.getResources().getString(2131690406));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svm
 * JD-Core Version:    0.7.0.1
 */