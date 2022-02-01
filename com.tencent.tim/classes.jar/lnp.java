import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.GalleryProteusItem.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class lnp
  implements lpi
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    if (paramInt == 103) {
      return llh.a(paramBaseArticleInfo);
    }
    if (paramInt == 102) {
      return llf.a(paramBaseArticleInfo);
    }
    return llg.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject = (lro)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject != null)
    {
      ((lro)localObject).setModel(paramlie, false);
      paramlie = paramlie.a();
      localObject = (NativeAvatarView)((lro)localObject).getNativeView();
      if ((kxm.k(paramlie)) && (paramlie.mGalleryFeedsInfo.uint32_is_account_derelict.has()) && (paramlie.mGalleryFeedsInfo.uint32_is_account_derelict.get() == 1)) {
        ((NativeAvatarView)localObject).setAvatarDrawable(paramContainer.getContext().getResources().getDrawable(2130847230));
      }
    }
    paramContainer = (NativeText)localViewBase.findViewBaseByName("id_nickname");
    paramlie = localViewBase.findViewBaseByName("id_view_nickname");
    if ((paramContainer != null) && (paramlie != null))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramlie = paramlie.getNativeView();
      if ((paramContainer != null) && (paramlie != null)) {
        paramlie.post(new GalleryProteusItem.1(this, paramlie, paramContainer));
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnp
 * JD-Core Version:    0.7.0.1
 */