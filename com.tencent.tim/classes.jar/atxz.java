import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.tbs.reader.TbsReaderView.ReaderCallback;
import com.tencent.tim.filemanager.fileviewer.FileView.LocalTbsViewManager.1.4;

public class atxz
  implements TbsReaderView.ReaderCallback
{
  atxz(atxy paramatxy, Activity paramActivity, atxy.a parama, String paramString) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = 10386;
    switch (paramInteger.intValue())
    {
    case 19: 
    default: 
    case 12: 
    case 5000: 
    case 5012: 
      for (;;)
      {
        this.val$activity.runOnUiThread(new LocalTbsViewManager.1.4(this, paramInteger));
        return;
        if (paramObject1 != null)
        {
          i = ((Bundle)paramObject1).getInt("function_id");
          paramObject1 = TbsReaderView.getResString(this.val$activity, i);
          paramObject2 = TbsReaderView.getResDrawable(this.val$activity, i + 1);
          Drawable localDrawable = TbsReaderView.getResDrawable(this.val$activity, i + 2);
          this.a.a(paramObject1, paramObject2, localDrawable, new atya(this, i));
          continue;
          if ((paramObject2 instanceof Bundle)) {}
          for (paramObject1 = (Bundle)paramObject2;; paramObject1 = new Bundle())
          {
            paramObject1.putBoolean("is_bar_animating", false);
            break;
          }
          if (((Integer)paramObject1).intValue() == 0)
          {
            paramObject1 = new Bundle();
            paramObject1.putString("filePath", this.aJN);
            paramObject1.putString("tempPath", Environment.getExternalStorageDirectory() + "/TbsReaderTemp");
            atxy.a(this.this$0).openFile(paramObject1);
          }
        }
      }
    }
    paramInteger = this.val$activity.getString(2131696537);
    if ((paramObject1 != null) && ((paramObject1 instanceof Bundle)))
    {
      paramObject2 = (Bundle)paramObject1;
      paramInteger = paramObject2.getString("tip");
      paramObject1 = paramObject2.getString("statistics");
      i = paramObject2.getInt("channel_id", 10386);
    }
    for (;;)
    {
      paramObject2 = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=" + i;
      aqha.a(this.val$activity, 233, this.val$activity.getString(2131690838), paramInteger, new atyb(this, paramObject1, paramObject2), new atyc(this)).show();
      return;
      paramObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxz
 * JD-Core Version:    0.7.0.1
 */