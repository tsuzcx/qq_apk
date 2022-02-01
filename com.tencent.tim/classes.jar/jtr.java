import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jtr
{
  public boolean isFirstEnter;
  private ArrayList<jts> jo = new ArrayList();
  private ArrayList<jts> jp = new ArrayList();
  public long puin;
  public long qH;
  public long qI;
  
  public ArrayList<jts> aZ()
  {
    return this.jo;
  }
  
  public void bK(ArrayList<jts> paramArrayList)
  {
    if (paramArrayList != null) {
      this.jo.addAll(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.jo.size());
    }
  }
  
  public void bL(ArrayList<String> paramArrayList)
  {
    this.jp.clear();
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      int j = 0;
      while (j < i)
      {
        String str = (String)paramArrayList.get(j);
        if (!TextUtils.isEmpty(str))
        {
          jts localjts = new jts();
          localjts.lo(str);
          this.jp.add(localjts);
        }
        j += 1;
      }
    }
    this.jo.addAll(this.jp);
    if (QLog.isColorLevel()) {
      QLog.d("parceJson2DynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.jp.size());
    }
  }
  
  public ArrayList<jts> ba()
  {
    return this.jp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtr
 * JD-Core Version:    0.7.0.1
 */