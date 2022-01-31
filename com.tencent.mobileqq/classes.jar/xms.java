import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter.3;
import com.tencent.image.URLDrawable;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class xms
  extends RecyclerView.Adapter<xmv>
  implements xmm
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private xmw jdField_a_of_type_Xmw;
  private xng jdField_a_of_type_Xng;
  
  public xms(Context paramContext, View.OnClickListener paramOnClickListener, xng paramxng)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Xng = paramxng;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      if ((!paramBoolean) || (this.jdField_a_of_type_Int == paramInt)) {
        break label44;
      }
    }
    label44:
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = -1)
    {
      notifyItemChanged(paramInt, Integer.valueOf(0));
      return;
    }
  }
  
  public String a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Int >= 0)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
        str1 = ((SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public xmv a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new xmv(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561528, paramViewGroup, false));
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(4);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorder(true);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new xmt(this, paramViewGroup));
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      if (this.jdField_a_of_type_Int < 0) {
        a(paramInt, true);
      }
    }
    while (this.jdField_a_of_type_Int < 0)
    {
      return;
      a(this.jdField_a_of_type_Int, false);
      a(paramInt, true);
      return;
    }
    a(this.jdField_a_of_type_Int, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    Collections.swap(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    SlideItemInfo localSlideItemInfo;
    if ((this.jdField_a_of_type_Int == paramInt1) || (this.jdField_a_of_type_Int == paramInt2))
    {
      if (this.jdField_a_of_type_Int == paramInt1)
      {
        this.jdField_a_of_type_Int = paramInt2;
        notifyItemChanged(paramInt1, Integer.valueOf(0));
        notifyItemChanged(paramInt2, Integer.valueOf(0));
      }
    }
    else
    {
      if (this.jdField_a_of_type_Xng != null) {
        this.jdField_a_of_type_Xng.a(paramInt1, paramInt2);
      }
      if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        if (localSlideItemInfo != null) {
          if (xna.a().a() != 11) {
            break label188;
          }
        }
      }
    }
    label188:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 = i;
      if (localSlideItemInfo.jdField_b_of_type_Int == 0) {
        paramInt2 = 0;
      }
      wxj.a("pic_choose_slides", "edit_seq", paramInt1, 0, new String[] { paramInt2 + "" });
      return;
      this.jdField_a_of_type_Int = paramInt1;
      break;
    }
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(xmv paramxmv, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    paramxmv.jdField_a_of_type_AndroidWidgetImageView.setTag(localSlideItemInfo);
    if (localSlideItemInfo != null)
    {
      if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
      {
        Object localObject = paramxmv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
        if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
        {
          localObject = bayu.a(localSlideItemInfo.jdField_a_of_type_JavaNetURL, bayu.b(), bayu.a());
          ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
          paramxmv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
          paramxmv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
        }
      }
      switch (localSlideItemInfo.jdField_b_of_type_Int)
      {
      }
    }
    while ((paramInt == this.jdField_a_of_type_Int) && (!paramxmv.jdField_a_of_type_Boolean))
    {
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      paramxmv.jdField_a_of_type_AndroidWidgetTextView.post(new SlideShowAdapter.3(this, paramxmv));
      return;
      paramxmv.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramxmv.jdField_b_of_type_AndroidWidgetTextView.setText(xnd.a(localSlideItemInfo.jdField_a_of_type_Long));
      continue;
      paramxmv.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (localSlideItemInfo.jdField_a_of_type_Long > 0L) {
        paramxmv.jdField_b_of_type_AndroidWidgetTextView.setText(xnd.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      }
      paramxmv.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new xmu(this, paramInt));
    }
    if (paramxmv.jdField_a_of_type_Boolean)
    {
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
      paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
      paramxmv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      return;
    }
    paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
    paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
    paramxmv.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    paramxmv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
  }
  
  public void a(xmw paramxmw)
  {
    this.jdField_a_of_type_Xmw = paramxmw;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xms
 * JD-Core Version:    0.7.0.1
 */