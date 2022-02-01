import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService.a;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class nel
  implements KandianVideoUploadService.a
{
  public nel(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void W(String paramString)
  {
    this.c.getCurrentActivity();
    lbz.a().mY(true);
    ReadInJoyBaseListViewGroup.a(this.c, paramString);
  }
  
  public void a(Bundle paramBundle, float paramFloat)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.c, paramBundle, "");
    if (this.c.eD.get(str) != null) {
      ((KandianProgressView)this.c.eD.get(str)).updateProgress((int)paramFloat);
    }
  }
  
  public void a(Bundle paramBundle, int paramInt, float paramFloat)
  {
    QLog.d("KandianVideoUpload", 1, paramBundle.getString("mTaskID") + "service中的状态:" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 200: 
      this.c.a.a(paramBundle, (int)paramFloat);
      return;
    case 202: 
      ReadInJoyBaseListViewGroup.a(this.c, paramBundle, "failed");
      return;
    }
    mit.aD(paramBundle);
  }
  
  public void a(Bundle paramBundle, String paramString)
  {
    paramString = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.c, paramBundle, "failed");
    if (this.c.eD.get(paramString) != null) {
      ((KandianProgressView)this.c.eD.get(paramString)).aVG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nel
 * JD-Core Version:    0.7.0.1
 */