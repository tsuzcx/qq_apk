import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ArticleItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.ArrayList;
import java.util.Map;

public class wfz
  extends FacePreloadBaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public wfz(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (getItemViewType(paramInt - 1) == 0) {
        return 1;
      }
      if ((paramInt >= 2) && (getItemViewType(paramInt - 2) == 0)) {
        return 2;
      }
    }
    return 3;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
        k = j + 1;
        paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    case 80000001: 
      return 3;
    case 80000003: 
      return 4;
    }
    return 5;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    switch (getItemViewType(paramInt))
    {
    default: 
    case 0: 
      do
      {
        return paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130969022, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131363360);
        if (UniteSearchActivity.d == 12) {
          if (((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals("公众号")) {
            paramView.setText(PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = ((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
          if (AppSetting.b)
          {
            ((View)localObject1).setFocusable(true);
            ((View)localObject1).setContentDescription(paramView.getText() + "搜索结果");
          }
          paramViewGroup = ((View)localObject1).findViewById(2131363905);
          if (paramInt <= 0) {
            break;
          }
          paramViewGroup.setVisibility(0);
          return localObject1;
          paramView.setText(((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
          continue;
          paramView.setText(((wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
        }
        paramView = (View)localObject1;
      } while (paramInt != 0);
      paramViewGroup.setVisibility(8);
      return localObject1;
    case 3: 
      localObject2 = (wfy)getItem(paramInt);
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = GroupViewAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
      }
      paramView = ((wfy)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      GroupViewAdapter.a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), ((wfy)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      paramViewGroup = (NearbyTroops.CustomViewHolder)((View)localObject1).getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131494210));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(((wfy)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      paramViewGroup.jdField_c_of_type_Int = 4;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_a_of_type_Int = a(paramInt);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      return localObject1;
    case 5: 
      if (paramView == null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130971295, paramViewGroup, false);
      }
      break;
    }
    for (;;)
    {
      if ((paramView instanceof QzoneSearchResultView))
      {
        paramViewGroup = (QzoneSearchResultView)paramView;
        localObject1 = (wfy)getItem(paramInt);
        paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, ((wfy)localObject1).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
        paramViewGroup.setAvartaView(a(1, paramViewGroup.a()));
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130970548, null);
          paramView = new SearchBaseFragment.ArticleItemViewHolder();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362851));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362852));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366663));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131371095));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371094));
          paramViewGroup.setTag(paramView);
        }
        SearchBaseFragment.ArticleItemViewHolder localArticleItemViewHolder = (SearchBaseFragment.ArticleItemViewHolder)paramViewGroup.getTag();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        wfy localwfy = (wfy)getItem(paramInt);
        if (localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
          PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
        }
        for (paramInt = 1;; paramInt = 0) {
          for (;;)
          {
            String str2 = "";
            String str1;
            Object localObject3;
            label855:
            int i;
            if (paramInt != 0)
            {
              localObject2 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
              str1 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
              localObject1 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
              localObject3 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
              paramView = localwfy.jdField_b_of_type_JavaLangString;
              SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, (String)localObject2);
              SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
              localArticleItemViewHolder.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              localArticleItemViewHolder.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              if (!TextUtils.isEmpty(localwfy.jdField_b_of_type_JavaLangString)) {
                SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localwfy.jdField_b_of_type_JavaLangString);
              }
              localArticleItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
              i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131559207);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            try
            {
              localObject3 = URLDrawable.getDrawable((String)localObject3, i, i);
              localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
              label933:
              localArticleItemViewHolder.jdField_a_of_type_JavaLangString = paramView;
              if (!"".equals(str1)) {
                localArticleItemViewHolder.d.setText(str1);
              }
              paramViewGroup.setTag(localArticleItemViewHolder);
              if (!"".equals(localObject2)) {
                localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject2));
              }
              if (paramInt == 0) {
                if (!"".equals(localObject1)) {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
                  {
                    localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                    label1041:
                    localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                  }
                }
              }
              for (;;)
              {
                paramView = (ImageView)paramViewGroup.findViewById(2131371092);
                paramView.setVisibility(4);
                localObject1 = (ImageView)paramViewGroup.findViewById(2131364453);
                ((ImageView)localObject1).setVisibility(4);
                if ((localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == SearchUtils.jdField_a_of_type_Int))
                {
                  paramView.setVisibility(0);
                  ((ImageView)localObject1).getBackground().setAlpha(25);
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = (TextView)paramViewGroup.findViewById(2131371093);
                ((TextView)localObject1).setVisibility(4);
                paramView = paramViewGroup;
                if (paramInt == 0) {
                  break;
                }
                ((TextView)localObject1).setVisibility(0);
                return paramViewGroup;
                localObject2 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
                str1 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
                localObject1 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
                localObject3 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
                str2 = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
                paramView = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
                localArticleItemViewHolder.jdField_a_of_type_Long = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
                localArticleItemViewHolder.jdField_a_of_type_Int = localwfy.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
                break label855;
                localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
                break label1041;
                localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                continue;
                if (!"".equals(localObject1))
                {
                  localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                  localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                }
                localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(190.0F, paramViewGroup.getResources()));
                localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
                localArticleItemViewHolder.d.setMaxLines(1);
              }
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130970147, paramViewGroup, false);
              }
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              paramView = new SearchBaseFragment.ItemViewHolder();
              paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131362851));
              paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131362852));
              paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131369310));
              paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131367432));
              paramView.d = ((TextView)((View)localObject1).findViewById(2131367433));
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((wfy)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((wfy)getItem(paramInt)).jdField_b_of_type_Int;
              ((View)localObject1).setTag(paramView);
              paramView = (SearchBaseFragment.ItemViewHolder)((View)localObject1).getTag();
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((wfy)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((wfy)getItem(paramInt)).jdField_b_of_type_Int;
              paramView.jdField_c_of_type_Int = a(paramInt);
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (wfy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              paramView = (View)localObject1;
              if (!AppSetting.b) {
                break;
              }
              ((View)localObject1).setContentDescription(paramViewGroup);
              return localObject1;
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130970149, paramViewGroup, false);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Wfx == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Wfx = new wfx(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              }
              ((View)localObject1).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Wfx);
              paramView = (View)localObject1;
              if (!AppSetting.b) {
                break;
              }
              ((View)localObject1).setContentDescription("查看更多" + this.jdField_a_of_type_JavaLangString + "搜索结果按钮");
              return localObject1;
            }
            catch (Exception localException)
            {
              break label933;
            }
          }
        }
      }
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfz
 * JD-Core Version:    0.7.0.1
 */