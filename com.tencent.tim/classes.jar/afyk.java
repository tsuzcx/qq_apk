import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class afyk
{
  public static final View.OnTouchListener A = new afyl();
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131561338, null);
    Object localObject3 = ((View)localObject1).findViewById(2131363859);
    ((View)localObject3).setOnTouchListener(A);
    ((View)localObject3).setOnClickListener(paramOnClickListener);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131369032);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131381118);
    Button localButton = (Button)((View)localObject1).findViewById(2131363926);
    localButton.setOnClickListener(paramOnClickListener);
    paramOnClickListener = new ViewGroup.LayoutParams(wja.dp2px(320.0F, paramContext.getResources()), -2);
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131755482);
    localReportDialog.addContentView((View)localObject1, paramOnClickListener);
    localReportDialog.setCanceledOnTouchOutside(false);
    int i;
    switch (paramInt)
    {
    default: 
      localObject1 = afxw.kL("expand_guide_profile.png");
      paramOnClickListener = acfp.m(2131709956);
      localObject3 = acfp.m(2131709955);
      i = wja.dp2px(163.0F, paramContext.getResources());
      paramInt = wja.dp2px(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      if (!new File((String)localObject1).exists()) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = afxw.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
        localImageView.setImageBitmap((Bitmap)localObject1);
        localTextView.setText(paramOnClickListener);
        localButton.setText(paramContext);
        paramContext = localImageView.getLayoutParams();
        paramContext.width = i;
        paramContext.height = paramInt;
        localImageView.setLayoutParams(paramContext);
        return localReportDialog;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "showFirstGuide decode bitmap fail.", localException);
      }
      localObject1 = afxw.kL("expand_guide_switch.png");
      paramOnClickListener = acfp.m(2131709957);
      localObject3 = acfp.m(2131709958);
      i = wja.dp2px(180.0F, paramContext.getResources());
      paramInt = wja.dp2px(102.0F, paramContext.getResources());
      paramContext = (Context)localObject3;
      break;
      Object localObject2 = null;
    }
  }
  
  public static Dialog b(Context paramContext)
  {
    Object localObject3 = null;
    View localView1 = LayoutInflater.from(paramContext).inflate(2131561339, null);
    View localView2 = localView1.findViewById(2131375379);
    View localView3 = localView1.findViewById(2131363859);
    ImageView localImageView = (ImageView)localView1.findViewById(2131375383);
    localView2.setOnTouchListener(A);
    localView3.setOnTouchListener(A);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(wja.dp2px(320.0F, paramContext.getResources()), -2);
    String str = afxw.kL("expand_question_dialog.png");
    Object localObject1 = localObject3;
    if (new File(str).exists()) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = afxw.decodeFile(str, (BitmapFactory.Options)localObject1);
      localImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = new ReportDialog(paramContext, 2131755482);
      ((Dialog)localObject1).addContentView(localView1, localLayoutParams);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      localView2.setOnClickListener(new afym(paramContext, (Dialog)localObject1));
      localView3.setOnClickListener(new afyn((Dialog)localObject1));
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProfileGuideDialogUtils", 1, "createQuestionDialog decode bitmap fail.", localException);
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyk
 * JD-Core Version:    0.7.0.1
 */