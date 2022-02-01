import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class xmt
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  xmu jdField_a_of_type_Xmu = new xmu();
  int[] jdField_a_of_type_ArrayOfInt = bfol.b(UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  public xmt(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public xmj a(int paramInt)
  {
    if (a(paramInt)) {
      return (xmj)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size();
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 3))
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int != 2)) {}
    }
    else {
      while (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 2)) && (((i == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int != 2)) || ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int == 2)))) {
        return i;
      }
    }
    return i + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    label109:
    boolean bool;
    label227:
    label239:
    int i;
    if (a(paramInt))
    {
      xmj localxmj;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561659, paramViewGroup, false);
        localObject2 = new xms(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1);
        localObject1 = this.jdField_a_of_type_Xmu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, (bjtz)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
        localxmj = a(paramInt);
        if (localxmj != null) {
          break label109;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (xms)paramView.getTag();
        localObject1 = paramView;
        break;
        Object localObject3 = localxmj.jdField_a_of_type_JavaLangString;
        Object localObject4;
        if ((localObject3 != null) && (!((String)localObject3).equals(((xms)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localObject4 = ((vvj)vux.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((xms)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            if (((localxmj.jdField_a_of_type_Int == 14) || (localxmj.jdField_a_of_type_Int == 13) || (localxmj.jdField_a_of_type_Int == 16) || (localxmj.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localxmj.b)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localxmj.b);
            }
            if (localxmj.jdField_f_of_type_Int != 4) {
              break label676;
            }
            bool = true;
            Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
            ImageView localImageView = ((xms)localObject2).jdField_a_of_type_AndroidWidgetImageView;
            float f1 = 50;
            TextView localTextView = ((xms)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            float f2 = 13;
            float f3 = 5;
            if (!bool) {
              break label682;
            }
            localObject3 = String.valueOf(localxmj.b);
            label291:
            wkp.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
          }
        }
        else
        {
          if (localxmj.jdField_a_of_type_Int != 1) {
            break label688;
          }
          ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((xms)localObject2).c.setVisibility(8);
          ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          label350:
          ((xms)localObject2).d.setText(localxmj.a());
          if (localxmj.jdField_f_of_type_Int != 4) {
            break label1995;
          }
          localObject3 = ContactUtils.getTroopName(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localxmj.b), true);
          ((xms)localObject2).e.setText((CharSequence)localObject3);
          ((xms)localObject2).e.setVisibility(0);
          ((xms)localObject2).f.setVisibility(8);
          label422:
          if ((!TextUtils.isEmpty(localxmj.b())) && (!localxmj.b().equals(((xms)localObject2).jdField_b_of_type_JavaLangString)))
          {
            ((xms)localObject2).jdField_b_of_type_JavaLangString = localxmj.b();
            localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130846810);
          }
        }
        try
        {
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "story_message";
          localObject4 = URLDrawable.getDrawable(localxmj.b(), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject4).setDecodeHandler(bfol.j);
          ((xms)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject4);
          if (localxmj.jdField_a_of_type_Vwh != null) {
            ((xms)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localxmj.jdField_a_of_type_Vwh, -1, null);
          }
          if (localxmj.jdField_a_of_type_Vwg != null) {
            ((xms)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localxmj.jdField_a_of_type_Vwg, -1, -1L, -1);
          }
          localObject3 = ((xms)localObject2).jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject3).setVisibility(i);
              this.jdField_a_of_type_Xmu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, paramInt, localxmj, (bjtz)localObject2, this);
              ((xms)localObject2).a(paramInt);
              continue;
              ((xms)localObject2).jdField_a_of_type_JavaLangString = null;
              break label227;
              label676:
              bool = false;
              break label239;
              label682:
              localObject3 = null;
              break label291;
              label688:
              if ((localxmj.jdField_a_of_type_Int == 2) || (localxmj.jdField_a_of_type_Int == 3))
              {
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713561));
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label350;
                }
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localxmj));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 4)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131713553));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713539));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((xms)localObject2).c.setVisibility(8);
                }
              }
              if (localxmj.jdField_a_of_type_Int == 12)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localxmj));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713540));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((xms)localObject2).c.setVisibility(8);
                }
              }
              if ((localxmj.jdField_a_of_type_Int == 14) || (localxmj.jdField_a_of_type_Int == 13))
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localxmj));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713541));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((xms)localObject2).c.setVisibility(8);
                }
              }
              if (localxmj.jdField_a_of_type_Int == 15)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localxmj));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713562));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((xms)localObject2).c.setVisibility(8);
                }
              }
              if ((localxmj.jdField_a_of_type_Int == 16) || (localxmj.jdField_a_of_type_Int == 17))
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localxmj));
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localxmj.jdField_a_of_type_Boolean)
                {
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713559));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((xms)localObject2).c.setVisibility(8);
                }
              }
              if (localxmj.jdField_a_of_type_Int == 5)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.j);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 6)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.jdField_e_of_type_JavaLangString);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 7)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.jdField_e_of_type_JavaLangString);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 8)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(2131698860);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 9)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.jdField_e_of_type_JavaLangString);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 10)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.jdField_e_of_type_JavaLangString);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 11)
              {
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localxmj.jdField_e_of_type_JavaLangString);
                ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((xms)localObject2).c.setVisibility(8);
                ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localxmj.jdField_a_of_type_Int == 18)
              {
                i = localxmj.jdField_e_of_type_Int;
                localObject3 = null;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                for (localObject3 = amtj.a(2131713558);; localObject3 = "@" + (String)localObject3 + amtj.a(2131713555))
                {
                  ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                  ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((xms)localObject2).c.setVisibility(8);
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localxmj.jdField_a_of_type_Int == 19)
              {
                if (localxmj.g)
                {
                  ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((xms)localObject2).c.setVisibility(0);
                  ((xms)localObject2).c.setText(amtj.a(2131713554));
                }
                for (;;)
                {
                  ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localxmj.jdField_f_of_type_Boolean)
                  {
                    ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    ((xms)localObject2).c.setVisibility(0);
                    ((xms)localObject2).c.setText(amtj.a(2131713546));
                  }
                  else
                  {
                    ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localxmj));
                    ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                    ((xms)localObject2).c.setVisibility(8);
                  }
                }
              }
              ((xms)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              ((xms)localObject2).c.setVisibility(8);
              ((xms)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label350;
              label1995:
              if (((localxmj.jdField_f_of_type_Int == 99) || (localxmj.jdField_f_of_type_Int == 104)) && (localxmj.jdField_a_of_type_Int != 6) && (localxmj.jdField_a_of_type_Int != 9))
              {
                ((xms)localObject2).e.setText(localxmj.k);
                ((xms)localObject2).e.setVisibility(0);
                ((xms)localObject2).f.setVisibility(8);
                break label422;
              }
              if (((localxmj.jdField_a_of_type_Int == 13) || (localxmj.jdField_a_of_type_Int == 14) || (localxmj.jdField_a_of_type_Int == 16) || (localxmj.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localxmj.p)))
              {
                if ("QQ好友".equals(localxmj.p)) {
                  ((xms)localObject2).e.setVisibility(8);
                }
                for (;;)
                {
                  ((xms)localObject2).f.setVisibility(8);
                  break;
                  ((xms)localObject2).e.setText(localxmj.p);
                  ((xms)localObject2).e.setVisibility(0);
                }
              }
              ((xms)localObject2).e.setVisibility(8);
              ((xms)localObject2).f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((xms)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject3);
            continue;
            i = 8;
            continue;
            i = 0;
          }
        }
      }
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561660, paramViewGroup, false);
      localObject1 = new xmr(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(localObject1);
      label2271:
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      ((xmr)localObject1).a(paramInt);
      localObject1 = paramView;
      break;
      localObject1 = (xmr)paramView.getTag();
      break label2271;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        ((xmr)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698845);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
        ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((xmr)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject2 = ((xmr)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130846422;; i = 2130846421)
        {
          ((ImageView)localObject2).setImageResource(i);
          break;
        }
        ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698845);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698845);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713542));
          continue;
          ((xmr)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((xmr)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698845);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, localException, new Object[0]);
        }
        int i = -1;
        continue;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131370711: 
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
          xwa.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmt
 * JD-Core Version:    0.7.0.1
 */