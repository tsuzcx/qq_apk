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

public class wsb
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
  
  public wsb(Context paramContext, int paramInt)
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
      ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = xod.a(getContext(), 3.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = xod.a(getContext(), 155.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = xod.a(getContext(), 307.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      xod.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, xod.a(getContext(), 307.0F), xod.a(getContext(), 155.0F), new wmn(xod.a(getContext(), 4.0F), 0, 0.504886F, null, null));
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
  
  public wsb a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public wsb a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public wsb a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public wsb b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public wsb b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public wsb b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public wsb c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public wsb c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public wsb d(String paramString)
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
  
  public wsb e(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561451);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373732));
    this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)findViewById(2131379817));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373733));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373731));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373730));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131373735));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131373736));
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
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) > xod.a(getContext(), 280.0F)) {
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
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new wsc(this));
      break label148;
      label314:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new wsd(this));
      }
    }
    label372:
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new wse(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsb
 * JD-Core Version:    0.7.0.1
 */