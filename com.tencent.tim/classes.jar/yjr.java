import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class yjr
  implements yjf
{
  View.OnClickListener C;
  private Context J;
  yjh a;
  QQAppInterface app;
  String mFriendUin;
  
  public yjr(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.J = paramContext;
    this.C = paramOnClickListener;
    this.mFriendUin = paramString;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.J).inflate(2131558815, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131364189);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131364190);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131364188);
    localTextView.setText(this.J.getResources().getString(2131697080));
    localImageView1.setImageResource(2130845740);
    paramVarArgs.setContentDescription(this.J.getResources().getString(2131697080));
    paramVarArgs.setOnClickListener(new yjs(this));
    localImageView2.setOnClickListener(this.C);
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 10;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public int wM()
  {
    return 36;
  }
  
  public void yK(String paramString)
  {
    this.mFriendUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */