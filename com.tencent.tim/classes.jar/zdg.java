import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class zdg
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  zdg(zdf paramzdf, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.this$0.t(this.ua);
  }
  
  protected void k(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      zdf.a(this.this$0, zdf.a(this.this$0), Long.valueOf(zdf.a(this.this$0)).longValue(), false, "");
      zdf.a(this.this$0);
      return;
    }
    int i = paramArrayList.size();
    anot.a(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    zdf.a(this.this$0).clear();
    zdf.a(this.this$0).addAll(paramArrayList);
    this.this$0.dh(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdg
 * JD-Core Version:    0.7.0.1
 */