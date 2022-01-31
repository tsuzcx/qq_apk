import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONException;
import org.json.JSONObject;

public class xva
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected Button a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected String a;
  private xvb jdField_a_of_type_Xvb;
  protected boolean a;
  private String b;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f;
  private String g;
  
  public xva(@NonNull Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.g = paramString;
  }
  
  public xva(@NonNull Context paramContext, String paramString)
  {
    this(paramContext, 2131755801, paramString);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (xsx.a(paramContext))
    {
      xsx.a(paramContext, "biz_src_jc_hyws", paramString4);
      return null;
    }
    paramContext = new xva(paramContext, "biz_src_jc_hyws").a(paramString1, paramString2, paramString3).a(paramInt, paramString4);
    paramContext.show();
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Xvb != null) {
      this.jdField_a_of_type_Xvb.a(this, paramInt);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363566));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368742));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369622);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378872));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131717326));
    a();
    if (TextUtils.isEmpty(this.b)) {
      this.b = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable(this.b, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new xvc(this.jdField_a_of_type_AndroidWidgetTextView));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    int i = ((URLDrawable)localObject).getStatus();
    if (i != 1)
    {
      if (i == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public xva a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public xva a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public xva a(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    return this;
  }
  
  public void a()
  {
    boolean bool = xsx.a(getContext());
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131717327));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131717330));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a(-1);
  }
  
  public void onClick(View paramView)
  {
    int m = 1;
    int i;
    label110:
    int k;
    label173:
    int j;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363566: 
      a();
      if (TextUtils.isEmpty(this.f))
      {
        if (this.jdField_a_of_type_Boolean) {
          xsx.a(getContext(), this.g, this.jdField_a_of_type_JavaLangString);
        }
        for (i = 0;; i = 1)
        {
          wxj.a("weishi_share", "cover_clk", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
          dismiss();
          a(i);
          return;
          QQToast.a(getContext(), alud.a(2131717328), 0).a();
          xsx.a(getContext(), this.g);
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        tam.a(getContext(), this.f);
        i = 0;
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label495;
        }
        k = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        j = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
        if ((j != 9) && (j != 12)) {
          break label373;
        }
        j = 1;
      }
      break;
    }
    for (;;)
    {
      label232:
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          paramView = "0";
          localJSONObject.put("download", paramView);
          if (j == 0) {
            continue;
          }
          j = m;
          ntd.a(localJSONObject, j);
        }
        catch (JSONException paramView)
        {
          label373:
          paramView.printStackTrace();
          continue;
          nrt.a(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(k), "", "", ntd.a(null, null, "", "", localJSONObject), false);
        }
        if (!"video_type_videopublic".equals(this.f)) {
          continue;
        }
        nrt.a(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(k), "", "", ntd.a(null, null, "", "", localJSONObject), false);
        break;
        QQToast.a(getContext(), -1, alud.a(2131717329), 0).b(getContext().getResources().getDimensionPixelSize(2131298914));
        tam.b(getContext(), this.f);
        i = 1;
        break label173;
        j = 0;
        break label232;
        paramView = "1";
        continue;
        j = 0;
      }
      break label110;
      dismiss();
      a(-1);
      if (!TextUtils.isEmpty(this.f)) {
        break;
      }
      wxj.a("weishi_share", "cover_close", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
      return;
      label495:
      j = 0;
      k = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561652);
    b();
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    if (TextUtils.isEmpty(this.f)) {
      wxj.a("weishi_share", "cover_exp", 0, 0, new String[] { this.d, this.c, "weishi", this.e });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xva
 * JD-Core Version:    0.7.0.1
 */