import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ahjy
  extends ahjv
{
  private String mName;
  private String mUin;
  
  public ahjy(Intent paramIntent)
  {
    super(paramIntent);
    this.mUin = paramIntent.getStringExtra("uin");
    this.mName = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559150, null);
    TextView localTextView = (TextView)localView.findViewById(2131381145);
    ImageView localImageView = (ImageView)localView.findViewById(2131369092);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    return a(String.format("[%s]%s", new Object[] { acfp.m(2131706488), this.mName }), aqdj.a(this.app, 1, this.mUin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjy
 * JD-Core Version:    0.7.0.1
 */