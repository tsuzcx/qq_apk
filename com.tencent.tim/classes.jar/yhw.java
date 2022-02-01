import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class yhw
  implements yjf
{
  private long JX = -1L;
  private TextView KL;
  private yjh a;
  private Context mContext;
  private View xH;
  
  public yhw(yjh paramyjh, Context paramContext)
  {
    this.mContext = paramContext;
    this.a = paramyjh;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public void P(Drawable paramDrawable)
  {
    if (this.xH != null)
    {
      ImageView localImageView = (ImageView)this.xH.findViewById(2131362522);
      if (localImageView != null) {
        localImageView.setImageDrawable(paramDrawable);
      }
    }
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.xH == null)
    {
      this.xH = LayoutInflater.from(this.mContext).inflate(2131558635, null);
      this.KL = ((TextView)this.xH.findViewById(2131362524));
      this.xH.setOnClickListener(new yhx(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[0] instanceof CharSequence)) && ((paramVarArgs[1] instanceof Long)))
    {
      this.KL.setText((CharSequence)paramVarArgs[0]);
      this.JX = ((Long)paramVarArgs[1]).longValue();
    }
    return this.xH;
  }
  
  public int getType()
  {
    return 16;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
  }
  
  public int wM()
  {
    return 55;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhw
 * JD-Core Version:    0.7.0.1
 */