import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class avjq
  implements amsq<ampw, amxy>
{
  public void a(ampw paramampw, amxy paramamxy)
  {
    avju localavju;
    int i;
    if (((paramampw instanceof avju)) && ((paramamxy instanceof amzk)))
    {
      localavju = (avju)paramampw;
      paramamxy = (amzk)paramamxy;
      paramampw = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
      if ((paramampw != null) && (paramampw.getStatus() == 2)) {
        paramampw.restartDownload();
      }
      paramamxy.w().setImageDrawable(paramampw);
      paramamxy.getTitleView().setText(avju.cLs);
      if (localavju.eX() != null) {
        break label204;
      }
      i = 0;
      if (i > 10) {
        break label218;
      }
    }
    label204:
    label218:
    for (paramampw = String.valueOf(i);; paramampw = "10+")
    {
      ((TextView)paramamxy.getView().findViewById(2131365740)).setText(String.format("%s条与\"", new Object[] { paramampw }));
      paramampw = (TextView)paramamxy.getView().findViewById(2131365734);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        paramampw.setTextColor(Color.parseColor("#004080"));
      }
      paramampw.setText(localavju.getKeyword());
      ((TextView)paramamxy.getView().findViewById(2131365741)).setText("\"相关收藏");
      paramamxy.v().setVisibility(8);
      paramamxy.getView().setOnClickListener(new avjr(this, localavju));
      return;
      i = localavju.eX().size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjq
 * JD-Core Version:    0.7.0.1
 */