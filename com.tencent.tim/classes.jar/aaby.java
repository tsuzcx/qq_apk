import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class aaby
  implements aabt
{
  private List<String> ve;
  
  public String a(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, boolean paramBoolean)
  {
    int i = paramCopyOnWriteArrayList.size() - 1;
    while (i >= 0)
    {
      String str = (String)paramCopyOnWriteArrayList.remove(i);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.ve == null)
      {
        this.ve = new ArrayList(4);
        this.ve.add("apple");
        this.ve.add("good");
        this.ve.add("study");
        this.ve.add("play");
      }
      i = new Random().nextInt(this.ve.size());
      if (QLog.isColorLevel()) {
        QLog.i("WordChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backWordListSize:" + this.ve.size());
      }
      return (String)this.ve.get(i);
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
    return !TextUtils.isEmpty(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaby
 * JD-Core Version:    0.7.0.1
 */