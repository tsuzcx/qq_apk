import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class aabu
  implements aabt
{
  private List<String> vd;
  
  public String a(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, boolean paramBoolean)
  {
    int i = paramCopyOnWriteArrayList.size() - 1;
    while (i >= 0)
    {
      String str = (String)paramCopyOnWriteArrayList.remove(i);
      if ((!TextUtils.isEmpty(str)) && (str.length() == 4)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.vd == null)
      {
        this.vd = new ArrayList();
        this.vd.add(acfp.m(2131707366));
        this.vd.add(acfp.m(2131707371));
        this.vd.add(acfp.m(2131707367));
        this.vd.add(acfp.m(2131707372));
        this.vd.add(acfp.m(2131707368));
        this.vd.add(acfp.m(2131707370));
        this.vd.add(acfp.m(2131707364));
        this.vd.add(acfp.m(2131707377));
        this.vd.add(acfp.m(2131707374));
        this.vd.add(acfp.m(2131707376));
        this.vd.add(acfp.m(2131707375));
      }
      i = new Random().nextInt(this.vd.size());
      if (QLog.isColorLevel()) {
        QLog.i("IdiomWordChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backIdiomListSize:" + this.vd.size());
      }
      return (String)this.vd.get(i);
    }
    return "";
  }
  
  public InputFilter[] a(int paramInt)
  {
    if ((aqfo.isFlyme()) || (aqfo.isMeizu())) {}
    for (int i = 1; (i == 0) && (paramInt > 0); i = 0) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
  
  public boolean iJ(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (aabk.bS(paramString) >= 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabu
 * JD-Core Version:    0.7.0.1
 */