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
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class yhn
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  yho jdField_a_of_type_Yho = new yho();
  int[] jdField_a_of_type_ArrayOfInt = bgey.b(zlx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), zlx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), zlx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  public yhn(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public yhd a(int paramInt)
  {
    if (a(paramInt)) {
      return (yhd)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
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
      yhd localyhd;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561740, paramViewGroup, false);
        localObject2 = new yhm(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1);
        localObject1 = this.jdField_a_of_type_Yho.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, (bkot)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
        localyhd = a(paramInt);
        if (localyhd != null) {
          break label109;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (yhm)paramView.getTag();
        localObject1 = paramView;
        break;
        Object localObject3 = localyhd.jdField_a_of_type_JavaLangString;
        Object localObject4;
        if ((localObject3 != null) && (!((String)localObject3).equals(((yhm)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localObject4 = ((wpy)wpm.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((yhm)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            if (((localyhd.jdField_a_of_type_Int == 14) || (localyhd.jdField_a_of_type_Int == 13) || (localyhd.jdField_a_of_type_Int == 16) || (localyhd.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localyhd.b)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localyhd.b);
            }
            if (localyhd.jdField_f_of_type_Int != 4) {
              break label676;
            }
            bool = true;
            Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
            ImageView localImageView = ((yhm)localObject2).jdField_a_of_type_AndroidWidgetImageView;
            float f1 = 50;
            TextView localTextView = ((yhm)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            float f2 = 13;
            float f3 = 5;
            if (!bool) {
              break label682;
            }
            localObject3 = String.valueOf(localyhd.b);
            label291:
            xfe.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
          }
        }
        else
        {
          if (localyhd.jdField_a_of_type_Int != 1) {
            break label688;
          }
          ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((yhm)localObject2).c.setVisibility(8);
          ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          label350:
          ((yhm)localObject2).d.setText(localyhd.a());
          if (localyhd.jdField_f_of_type_Int != 4) {
            break label1995;
          }
          localObject3 = bglf.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localyhd.b), true);
          ((yhm)localObject2).e.setText((CharSequence)localObject3);
          ((yhm)localObject2).e.setVisibility(0);
          ((yhm)localObject2).f.setVisibility(8);
          label422:
          if ((!TextUtils.isEmpty(localyhd.b())) && (!localyhd.b().equals(((yhm)localObject2).jdField_b_of_type_JavaLangString)))
          {
            ((yhm)localObject2).jdField_b_of_type_JavaLangString = localyhd.b();
            localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130846885);
          }
        }
        try
        {
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "story_message";
          localObject4 = URLDrawable.getDrawable(localyhd.b(), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject4).setDecodeHandler(bgey.j);
          ((yhm)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject4);
          if (localyhd.jdField_a_of_type_Wqw != null) {
            ((yhm)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localyhd.jdField_a_of_type_Wqw, -1, null);
          }
          if (localyhd.jdField_a_of_type_Wqv != null) {
            ((yhm)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localyhd.jdField_a_of_type_Wqv, -1, -1L, -1);
          }
          localObject3 = ((yhm)localObject2).jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject3).setVisibility(i);
              this.jdField_a_of_type_Yho.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, paramInt, localyhd, (bkot)localObject2, this);
              ((yhm)localObject2).a(paramInt);
              continue;
              ((yhm)localObject2).jdField_a_of_type_JavaLangString = null;
              break label227;
              label676:
              bool = false;
              break label239;
              label682:
              localObject3 = null;
              break label291;
              label688:
              if ((localyhd.jdField_a_of_type_Int == 2) || (localyhd.jdField_a_of_type_Int == 3))
              {
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713220));
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label350;
                }
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localyhd));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 4)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131713212));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713198));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((yhm)localObject2).c.setVisibility(8);
                }
              }
              if (localyhd.jdField_a_of_type_Int == 12)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localyhd));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713199));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((yhm)localObject2).c.setVisibility(8);
                }
              }
              if ((localyhd.jdField_a_of_type_Int == 14) || (localyhd.jdField_a_of_type_Int == 13))
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localyhd));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713200));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((yhm)localObject2).c.setVisibility(8);
                }
              }
              if (localyhd.jdField_a_of_type_Int == 15)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localyhd));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713221));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((yhm)localObject2).c.setVisibility(8);
                }
              }
              if ((localyhd.jdField_a_of_type_Int == 16) || (localyhd.jdField_a_of_type_Int == 17))
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localyhd));
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyhd.jdField_a_of_type_Boolean)
                {
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713218));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((yhm)localObject2).c.setVisibility(8);
                }
              }
              if (localyhd.jdField_a_of_type_Int == 5)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.j);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 6)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.jdField_e_of_type_JavaLangString);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 7)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.jdField_e_of_type_JavaLangString);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 8)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(2131698518);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 9)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.jdField_e_of_type_JavaLangString);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 10)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.jdField_e_of_type_JavaLangString);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 11)
              {
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyhd.jdField_e_of_type_JavaLangString);
                ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((yhm)localObject2).c.setVisibility(8);
                ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyhd.jdField_a_of_type_Int == 18)
              {
                i = localyhd.jdField_e_of_type_Int;
                localObject3 = null;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                for (localObject3 = anni.a(2131713217);; localObject3 = "@" + (String)localObject3 + anni.a(2131713214))
                {
                  ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                  ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((yhm)localObject2).c.setVisibility(8);
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localyhd.jdField_a_of_type_Int == 19)
              {
                if (localyhd.g)
                {
                  ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((yhm)localObject2).c.setVisibility(0);
                  ((yhm)localObject2).c.setText(anni.a(2131713213));
                }
                for (;;)
                {
                  ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localyhd.jdField_f_of_type_Boolean)
                  {
                    ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    ((yhm)localObject2).c.setVisibility(0);
                    ((yhm)localObject2).c.setText(anni.a(2131713205));
                  }
                  else
                  {
                    ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localyhd));
                    ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                    ((yhm)localObject2).c.setVisibility(8);
                  }
                }
              }
              ((yhm)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              ((yhm)localObject2).c.setVisibility(8);
              ((yhm)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label350;
              label1995:
              if (((localyhd.jdField_f_of_type_Int == 99) || (localyhd.jdField_f_of_type_Int == 104)) && (localyhd.jdField_a_of_type_Int != 6) && (localyhd.jdField_a_of_type_Int != 9))
              {
                ((yhm)localObject2).e.setText(localyhd.k);
                ((yhm)localObject2).e.setVisibility(0);
                ((yhm)localObject2).f.setVisibility(8);
                break label422;
              }
              if (((localyhd.jdField_a_of_type_Int == 13) || (localyhd.jdField_a_of_type_Int == 14) || (localyhd.jdField_a_of_type_Int == 16) || (localyhd.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localyhd.p)))
              {
                if ("QQ好友".equals(localyhd.p)) {
                  ((yhm)localObject2).e.setVisibility(8);
                }
                for (;;)
                {
                  ((yhm)localObject2).f.setVisibility(8);
                  break;
                  ((yhm)localObject2).e.setText(localyhd.p);
                  ((yhm)localObject2).e.setVisibility(0);
                }
              }
              ((yhm)localObject2).e.setVisibility(8);
              ((yhm)localObject2).f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((yhm)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject3);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561741, paramViewGroup, false);
      localObject1 = new yhl(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(localObject1);
      label2271:
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      ((yhl)localObject1).a(paramInt);
      localObject1 = paramView;
      break;
      localObject1 = (yhl)paramView.getTag();
      break label2271;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        ((yhl)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698503);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
        ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((yhl)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject2 = ((yhl)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130846497;; i = 2130846496)
        {
          ((ImageView)localObject2).setImageResource(i);
          break;
        }
        ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698503);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698503);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131713201));
          continue;
          ((yhl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((yhl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698503);
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
        case 2131370639: 
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
          yqu.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhn
 * JD-Core Version:    0.7.0.1
 */