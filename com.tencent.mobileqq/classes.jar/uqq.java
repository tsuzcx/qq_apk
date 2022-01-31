import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.io.File;

public class uqq
  extends Dialog
{
  private int jdField_a_of_type_Int = -1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoView jdField_a_of_type_AndroidWidgetVideoView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  public uqq(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetVideoView.setVideoPath(this.e);
      this.jdField_a_of_type_AndroidWidgetVideoView.setZOrderOnTop(true);
      this.jdField_a_of_type_AndroidWidgetVideoView.start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(8);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "story_rename_guide";
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = vms.a(getContext(), 3.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vms.a(getContext(), 155.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vms.a(getContext(), 307.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      vms.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, vms.a(getContext(), 307.0F), vms.a(getContext(), 155.0F), new ulc(vms.a(getContext(), 4.0F), 0, 0.504886F, null, null));
      return;
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public uqq a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public uqq a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public uqq a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public uqq b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public uqq b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public uqq b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public uqq c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public uqq c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public uqq d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void dismiss()
  {
    if ((this.jdField_a_of_type_AndroidWidgetVideoView != null) && (this.jdField_a_of_type_AndroidWidgetVideoView.isPlaying())) {
      this.jdField_a_of_type_AndroidWidgetVideoView.stopPlayback();
    }
    super.dismiss();
  }
  
  public uqq e(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131495671);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131307568));
    this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)findViewById(2131313285));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307569));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131307567));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307566));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131307571));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131307572));
    a();
    b();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(this.d)) {
        break label256;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label148:
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label314;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewView$OnClickListener == null) {
        break label372;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) > vms.a(getContext(), 280.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      label256:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.d);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label148;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new uqr(this));
      break label148;
      label314:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new uqs(this));
      }
    }
    label372:
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new uqt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */