import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agoa
  implements agnz
{
  private QQAppInterface mApp;
  private Context mContext;
  private List<Integer> mTypes;
  private String mUin;
  
  public agoa(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, List<Integer> paramList)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mUin = paramString;
    this.mTypes = paramList;
  }
  
  public void Ok(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.i("QFileOfflineSearchTypeController", 4, "unknown search type.");
      return;
    case 3: 
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 1, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.mContext, paramInt, this.mUin, this.mTypes);
      return;
    case 2: 
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 2, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.mContext, paramInt, this.mUin, this.mTypes);
      return;
    case 0: 
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 3, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.mContext, paramInt, this.mUin, this.mTypes);
      return;
    case 1: 
      anot.a(this.mApp, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 4, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.mContext, paramInt, this.mUin, this.mTypes);
      return;
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 5, 0, "", "", "", "");
    SearchTypeDetailActivity.a(this.mContext, paramInt, this.mUin, this.mTypes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agoa
 * JD-Core Version:    0.7.0.1
 */