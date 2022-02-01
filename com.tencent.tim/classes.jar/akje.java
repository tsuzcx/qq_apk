import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akje
  extends akjd
{
  public akje(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(akhv.a parama)
  {
    return 1;
  }
  
  public akhv.a a()
  {
    return new akje.a();
  }
  
  public View a(ViewGroup paramViewGroup, akhv.a parama)
  {
    parama = (akje.a)parama;
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561485, paramViewGroup, false);
    parama.qp = ((TextView)paramViewGroup.findViewById(2131380966));
    parama.jF = ((ImageView)paramViewGroup.findViewById(2131369717));
    parama.BL = ((ImageView)paramViewGroup.findViewById(2131369837));
    return paramViewGroup;
  }
  
  public String a(akhv.a parama)
  {
    long l = ((akjm)((akje.a)parama).b).duration;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void e(akhv.a parama)
  {
    akjm localakjm = (akjm)parama.b;
    if ((localakjm.g != null) && (localakjm.g.publishState != 0))
    {
      akja.a(this.mContext, localakjm.g, 2);
      return;
    }
    super.e(parama);
  }
  
  public void h(akhv.a parama)
  {
    akje.a locala = (akje.a)parama;
    akjm localakjm = (akjm)locala.b;
    parama = aqmw.a(this.mContext, locala.b.a, localakjm.agQ);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(parama))
    {
      locala.qp.setVisibility(8);
      j = rpq.dip2px(this.mContext, 180.0F);
      str = (String)locala.jF.getTag(2131379238);
      if (localakjm.g == null) {
        break label544;
      }
      localFile = new File(localakjm.g.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localakjm.g.thumbPath;
        parama = (akhv.a)localObject;
        if (localakjm.g.videoWidth <= 0) {
          break label539;
        }
        parama = (akhv.a)localObject;
        if (localakjm.g.videoHeight <= 0) {
          break label539;
        }
        i = localakjm.g.videoHeight * j / localakjm.g.videoWidth;
        parama = (akhv.a)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, parama))
          {
            locala.jF.setTag(2131379238, parama);
            localObject = (FrameLayout.LayoutParams)locala.jF.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            locala.jF.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846397);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mContext.getResources().getDrawable(2130846397);
              if (!bool) {
                continue;
              }
              parama = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              parama.setTag(aqbn.d(j, i, aqcx.dip2px(this.mContext, 3.0F)));
              parama.setDecodeHandler(aqbn.f);
              locala.jF.setImageDrawable(parama);
              return;
            }
            catch (Exception parama)
            {
              label444:
              locala.jF.setImageDrawable(this.mContext.getResources().getDrawable(2130846397));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, parama.toString());
              return;
            }
            locala.qp.setVisibility(0);
            if ((parama instanceof SpannableString)) {
              locala.qp.setMovementMethod(LinkMovementMethod.getInstance());
            }
            locala.qp.setText(parama);
            break;
            localObject = localakjm.faceUrl;
            parama = (akhv.a)localObject;
            if (localakjm.width <= 0) {
              break label539;
            }
            parama = (akhv.a)localObject;
            if (localakjm.height <= 0) {
              break label539;
            }
            i = localakjm.height * j / localakjm.width;
            parama = (akhv.a)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              locala.jF.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              parama = URLDrawable.getDrawable(parama, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
  
  public class a
    extends akhv.a
  {
    public ImageView BL;
    public ImageView jF;
    public TextView qp;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akje
 * JD-Core Version:    0.7.0.1
 */