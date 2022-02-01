import android.app.Activity;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class xsv
  implements AdapterView.OnItemClickListener
{
  xsv(xsk paramxsk, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.this$0.c.dismiss();
    localObject = ((ShareActionSheetBuilder.b)localObject).b;
    int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
    localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
    switch (i)
    {
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 65: 
    case 66: 
    case 68: 
    default: 
      label148:
      i = -1;
    }
    for (;;)
    {
      label151:
      if (this.awl) {}
      int j;
      for (localObject = "0X8009EF7";; localObject = "0X8009EFA")
      {
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
        break;
        xsk.a(this.this$0, this.d);
        i = 1;
        break label151;
        xsk.b(this.this$0, this.d);
        i = 5;
        break label151;
        if (this.awl) {}
        for (i = 6;; i = 5)
        {
          j = i;
          if (!this.this$0.a.asBinder().pingBinder()) {
            break label727;
          }
          this.this$0.a.saveToWeiyun(this.d.id);
          QQToast.a(xsk.A(this.this$0), xsk.B(this.this$0).getString(2131694101), 0).show();
          break;
        }
        if (!this.this$0.a.asBinder().pingBinder()) {
          break label148;
        }
        this.this$0.a.sendFileToPC(this.d.id);
        anot.a(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
        QQToast.a(xsk.C(this.this$0), 2, xsk.D(this.this$0).getString(2131693980), 0).show();
        i = -1;
        break label151;
        xsk.a(this.this$0, this.d, this.S);
        i = 2;
        break label151;
        j = 3;
        if (!this.this$0.a.asBinder().pingBinder()) {
          break label727;
        }
        this.this$0.a.favorite(this.d.id);
        i = 3;
        break label151;
        if (this.awl) {}
        for (i = 7;; i = 6)
        {
          String str = this.this$0.QE;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.this$0.mFriendUin;
          }
          xsk.a(xsk.E(this.this$0), this.this$0.mCurType, this.this$0.mFriendUin, (String)localObject, this.d.time, this.d.shmsgseq, this.d.istroop, false);
          break;
        }
        OCRResultActivity.n(xsk.F(this.this$0), this.S.getAbsolutePath(), 1);
        i = 8;
        break label151;
        xsk.a(this.this$0, this.d, (String)localObject);
        i = 9;
        break label151;
        xsk.b(this.this$0, this.d, (String)localObject);
        i = 10;
        break label151;
        i = 11;
        localObject = (AIOFileVideoData)this.d;
        ahav.F(xsk.G(this.this$0), ((AIOFileVideoData)localObject).mFilePath);
        break label151;
        PicShareToWX.a(this.S.getPath(), xsk.H(this.this$0), 1);
        anot.a(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break label148;
      }
      label727:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsv
 * JD-Core Version:    0.7.0.1
 */