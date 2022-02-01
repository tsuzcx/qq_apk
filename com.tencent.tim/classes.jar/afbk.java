import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afbk
  extends aquy
{
  public afbk(DataReportSettingFragment paramDataReportSettingFragment, String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(this.val$filePath);
      if (paramaquz.exists()) {
        paramaquz = aqhq.readFileContent(paramaquz);
      }
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramaquz = new JSONArray(paramaquz);
        localArrayList = new ArrayList(paramaquz.length());
        i = 0;
        if (i < paramaquz.length())
        {
          JSONObject localJSONObject = paramaquz.optJSONObject(i);
          if (TextUtils.isEmpty(localJSONObject.optString("group"))) {
            localArrayList.add(afbz.a(localJSONObject));
          } else {
            localArrayList.add(afca.a(localJSONObject));
          }
        }
      }
      catch (JSONException paramaquz)
      {
        paramaquz.printStackTrace();
      }
      do
      {
        return;
        this.a.getActivity().runOnUiThread(new DataReportSettingFragment.4.1(this, localArrayList));
        return;
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarFragment", 2, "downloadGuide failed");
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbk
 * JD-Core Version:    0.7.0.1
 */