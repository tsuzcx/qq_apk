import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class kvo
{
  private static final int aMd = Utils.rp2px(10.0D);
  
  private static int a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null)
    {
      QLog.i("DividerConfigUtils", 1, "templateBean TYPE_UNKNOWN == null");
      return -1;
    }
    if (paramTemplateBean.findViewById("id_separator_normal_bottom") != null) {
      return 1;
    }
    if (paramTemplateBean.findViewById("id_separator_special_bottom_space") != null) {
      return 2;
    }
    QLog.i("DividerConfigUtils", 1, "getViewType TYPE_UNKNOWN" + paramTemplateBean);
    return -1;
  }
  
  private static int a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    Layout.Params localParams = paramViewBase.getComLayoutParams();
    int i = localParams.mLayoutHeight;
    if (paramBoolean) {}
    for (localParams.mLayoutHeight = aMd;; localParams.mLayoutHeight = 0)
    {
      paramViewBase.setComLayoutParams(localParams);
      return localParams.mLayoutHeight - i;
    }
  }
  
  public static boolean a(Container paramContainer, lie paramlie)
  {
    int i = 0;
    if ((paramContainer == null) || (paramlie == null)) {}
    Object localObject;
    int j;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = paramlie.b();
        } while (localObject == null);
        j = paramlie.getPosition();
        paramlie = ((ndi)localObject).c(j);
        localObject = ((ndi)localObject).c(j + 1);
      } while ((paramlie == null) || (localObject == null));
      j = a(paramlie.mProteusTemplateBean);
    } while (j == -1);
    int k = a(((BaseArticleInfo)localObject).mProteusTemplateBean);
    QLog.i("DividerConfigUtils", 1, "topType:" + j + " nextType:" + k);
    if (k < 0) {
      QLog.i("DividerConfigUtils", 1, "nextArticleInfo:" + ((BaseArticleInfo)localObject).mProteusTemplateBean);
    }
    paramlie = paramContainer.getVirtualView();
    switch (j)
    {
    }
    for (;;)
    {
      localObject = paramlie.getComLayoutParams();
      if (((Layout.Params)localObject).mLayoutHeight >= 0) {
        ((Layout.Params)localObject).mLayoutHeight = (i + ((Layout.Params)localObject).mLayoutHeight);
      }
      paramlie = paramlie.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramlie.mLayoutWidth, paramlie.mLayoutHeight));
      return true;
      localObject = paramlie.findViewBaseByName("id_separator_normal_bottom");
      switch (k)
      {
      default: 
        i = b((ViewBase)localObject, true);
        break;
      case 2: 
        i = b((ViewBase)localObject, false);
        continue;
        localObject = paramlie.findViewBaseByName("id_separator_special_bottom_space");
        switch (k)
        {
        default: 
          i = a((ViewBase)localObject, false);
          break;
        case 2: 
          i = a((ViewBase)localObject, true);
        }
        break;
      }
    }
  }
  
  private static int b(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramViewBase.setVisibility(i);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvo
 * JD-Core Version:    0.7.0.1
 */