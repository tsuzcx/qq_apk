import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class afzn
{
  private ArrayList<afub> wx = new ArrayList();
  
  public static String b(String paramString, Context paramContext)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      paramString.replaceAll("\n|\r\n", " ");
      str = paramString;
    } while (paramString.length() <= 20);
    paramString = paramString.substring(0, 19);
    return paramString + paramContext.getResources().getString(2131701127);
  }
  
  public afub a(int paramInt)
  {
    return (afub)this.wx.get(paramInt);
  }
  
  public View a(Context paramContext, afub paramafub, ViewGroup paramViewGroup)
  {
    if (paramafub == null) {}
    int i;
    do
    {
      return null;
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131561347, null);
      if (paramViewGroup == null) {
        break;
      }
      i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297581);
      if (paramafub.tagName == null) {
        paramafub.tagName = "";
      }
      paramContext = b(paramafub.tagName, paramContext);
    } while (paramContext == null);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131379401);
    localTextView.setText(paramafub.tagName);
    localTextView.setTextSize(0, i);
    localTextView.setText(paramContext);
    localTextView.setSingleLine(true);
    paramContext = (ImageView)paramViewGroup.findViewById(2131368698);
    if (paramafub.akn()) {
      paramContext.setBackgroundResource(2130846014);
    }
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-2, BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297578)));
    return paramViewGroup;
  }
  
  public void eh(ArrayList<afub> paramArrayList)
  {
    int i = 0;
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
    for (;;)
    {
      return;
      this.wx.clear();
      if (paramArrayList.size() < 16)
      {
        i = j;
        while (i < 16)
        {
          j = paramArrayList.size();
          this.wx.add(paramArrayList.get(i % j));
          i += 1;
        }
      }
      else
      {
        while (i < paramArrayList.size())
        {
          this.wx.add(paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.wx.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzn
 * JD-Core Version:    0.7.0.1
 */