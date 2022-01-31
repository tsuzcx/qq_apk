import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class umo
  extends umg
  implements View.OnClickListener
{
  public Context a;
  public View a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ShareGroupInnerListView a;
  public VideoCollectionItem a;
  public final umm a;
  public View b;
  public ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public umo(View paramView, umm paramumm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramumm.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377263));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364353));
    this.c = ((TextView)paramView.findViewById(2131364358));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369894));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView = ((ShareGroupInnerListView)paramView.findViewById(2131368183));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
    bawi.a(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView, false);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setFocusable(false);
    this.jdField_a_of_type_Umm = paramumm;
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setLoadMoreDataListener(this.jdField_a_of_type_Umm.jdField_a_of_type_Umw);
    paramumm = (uui)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.a();
    paramumm.a(this.jdField_a_of_type_Umm.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId);
    paramumm.a(this.jdField_a_of_type_Umm.jdField_a_of_type_Umw);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369207);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369208);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371826));
    this.d = ((TextView)paramView.findViewById(2131362131));
    a();
  }
  
  protected void a()
  {
    QQStoryContext.a();
    if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845711);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#0c284e"));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845707);
    this.c.setTextColor(Color.parseColor("#44608a"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem = paramVideoCollectionItem;
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_empty_item"))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramView.height = Integer.valueOf(paramVideoCollectionItem.collectionId).intValue();
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if (TextUtils.equals(paramVideoCollectionItem.key, "local_desc_item"))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setVisibility(0);
    this.jdField_a_of_type_Umm.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
    paramView = vyb.a(paramVideoCollectionItem.collectionTime);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView[1]);
    Object localObject;
    if (!TextUtils.isEmpty(paramView[0]))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramView[0]);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 32.0F);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, vzo.a(this.jdField_a_of_type_AndroidContentContext, -8.0F), 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setSelection(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.resetCurrentX(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView.setData(paramVideoCollectionItem);
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = vzo.a(this.jdField_a_of_type_AndroidContentContext, 80.0F);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((paramVideoCollectionItem.collectionCount > 0) || (paramInt != 2)) {
        break label655;
      }
      this.c.setText(ajyc.a(2131713921));
      label382:
      localObject = this.jdField_a_of_type_Umm.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
      if ((((ShareGroupItem)localObject).type != 2) || (!((ShareGroupItem)localObject).isPublic()) || (paramVideoCollectionItem.collectionCount <= 0)) {
        break label689;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label439:
      if (!TextUtils.isEmpty(paramVideoCollectionItem.address)) {
        break label701;
      }
      this.d.setVisibility(4);
      label457:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoCollectionItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (paramInt != 2) {
        break label740;
      }
      paramVideoCollectionItem.height = vzo.a(this.jdField_a_of_type_AndroidContentContext, 150.0F);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramVideoCollectionItem);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if ((paramInt == 3) && (TextUtils.equals(paramView[1], ajyc.a(2131713914)))) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, vzo.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, vzo.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      }
      label655:
      this.c.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699518, new Object[] { Integer.valueOf(paramVideoCollectionItem.collectionCount) }));
      break label382;
      label689:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label439;
      label701:
      paramVideoCollectionItem.address = paramVideoCollectionItem.address.replace(65292, '‧');
      this.d.setText(paramVideoCollectionItem.address);
      this.d.setVisibility(0);
      break label457;
      label740:
      if (TextUtils.equals(paramView[1], ajyc.a(2131713918))) {
        paramVideoCollectionItem.height = vzo.a(this.jdField_a_of_type_AndroidContentContext, 172.0F);
      } else {
        paramVideoCollectionItem.height = vzo.a(this.jdField_a_of_type_AndroidContentContext, 176.0F);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.size() == 0)
    {
      veg.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "no data to share");
      return;
    }
    vyb.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionCount;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionVideoUIItemList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramView = (uuf)localIterator.next();
    } while ((paramView == null) || (uuk.a(paramView)) || (0 != 0));
    for (;;)
    {
      if (paramView != null)
      {
        this.jdField_a_of_type_Umm.jdField_a_of_type_Umw.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionId, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.collectionTime, paramView.a, i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.feedId, null);
        return;
      }
      veg.b("Q.qqstory.shareGroup.ShareGroupsListAdapter", "cannot found first data to share to qq");
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umo
 * JD-Core Version:    0.7.0.1
 */