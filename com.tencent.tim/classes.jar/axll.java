import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class axll
{
  private HashMap<String, String> bx;
  private TextView textView;
  
  private String HU()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("调试信息：\n");
    Iterator localIterator = this.bx.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str + "：" + (String)this.bx.get(str) + "\n");
    }
    return localStringBuilder.toString();
  }
  
  public void aN(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length / 2)
    {
      this.bx.put(paramArrayOfString[(i * 2)], paramArrayOfString[(i * 2 + 1)]);
      i += 1;
    }
    if (this.textView != null) {
      this.textView.setText(HU());
    }
  }
  
  public void update(String paramString1, String paramString2)
  {
    this.bx.put(paramString1, paramString2);
    if (this.textView != null) {
      this.textView.setText(HU());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axll
 * JD-Core Version:    0.7.0.1
 */