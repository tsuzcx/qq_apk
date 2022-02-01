import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class akjc
  extends akjd
{
  public akjc(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(akhv.a parama)
  {
    return 2;
  }
  
  public akhv.a a()
  {
    return new akjc.a();
  }
  
  public View a(ViewGroup paramViewGroup, akhv.a parama)
  {
    parama = (akjc.a)parama;
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561484, paramViewGroup, false);
    parama.qp = ((TextView)paramViewGroup.findViewById(2131380966));
    parama.imageView = ((ImageView)paramViewGroup.findViewById(2131369834));
    return paramViewGroup;
  }
  
  public void e(akhv.a parama)
  {
    akjk localakjk = (akjk)parama.b;
    if ((localakjk.g != null) && (localakjk.g.publishState != 0))
    {
      akja.a(this.mContext, localakjk.g, 4);
      return;
    }
    super.e(parama);
  }
  
  public void h(akhv.a parama)
  {
    akjc.a locala = (akjc.a)parama;
    Object localObject1 = (akjk)locala.b;
    parama = ((akjk)localObject1).agQ;
    parama = aqmw.a(this.mContext, locala.b.a, parama);
    Object localObject2;
    if (TextUtils.isEmpty(parama))
    {
      locala.qp.setVisibility(8);
      localObject2 = (String)locala.imageView.getTag(2131379238);
      if (((akjk)localObject1).g == null) {
        break label475;
      }
      parama = new File(((akjk)localObject1).g.thumbPath + "");
    }
    for (boolean bool = parama.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((akjk)localObject1).g.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          locala.imageView.setTag(2131379238, localObject1);
          localObject2 = (LinearLayout.LayoutParams)locala.imageView.getLayoutParams();
          i = rpq.dip2px(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          locala.imageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846397);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130846397);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          parama = URLDrawable.getDrawable(parama, (URLDrawable.URLDrawableOptions)localObject2);
          parama.setTag(aqbn.c(aqcx.dip2px(locala.imageView.getContext(), 3.0F), 0, 0));
          parama.setDecodeHandler(aqbn.g);
          locala.imageView.setImageDrawable(parama);
        }
        catch (Exception parama)
        {
          label368:
          locala.imageView.setImageDrawable(this.mContext.getResources().getDrawable(2130846397));
          QLog.i("PicMomentItemBuilder", 1, parama.toString());
          continue;
        }
        locala.imageView.setTag(locala);
        locala.imageView.setOnClickListener(this);
        return;
        locala.qp.setVisibility(0);
        if ((parama instanceof SpannableString)) {
          locala.qp.setMovementMethod(LinkMovementMethod.getInstance());
        }
        locala.qp.setText(parama);
        break;
        localObject1 = ((akjk)localObject1).picUrl;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            locala.imageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            parama = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      parama = null;
    }
  }
  
  public class a
    extends akhv.a
  {
    public ImageView imageView;
    public TextView qp;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjc
 * JD-Core Version:    0.7.0.1
 */