import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class yiw
  implements yjf
{
  private String linkUrl;
  private Context mContext;
  private ImageView mIconView;
  private TextView mTextView;
  private View xH;
  
  public yiw(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.xH == null)
    {
      this.xH = LayoutInflater.from(this.mContext).inflate(2131558700, null);
      this.mTextView = ((TextView)this.xH.findViewById(2131362549));
      this.mIconView = ((ImageView)this.xH.findViewById(2131362548));
      this.mIconView.setImageResource(2130848213);
      this.xH.setOnClickListener(new yix(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof String))) {
      paramVarArgs = new String(Base64.decode((String)paramVarArgs[0], 0));
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs);
      String str = paramVarArgs.getString("content");
      this.mTextView.setText(str);
      this.linkUrl = paramVarArgs.getString("url");
      label150:
      return this.xH;
    }
    catch (JSONException paramVarArgs)
    {
      break label150;
    }
  }
  
  public int getType()
  {
    return 17;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public int wM()
  {
    return 66;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiw
 * JD-Core Version:    0.7.0.1
 */