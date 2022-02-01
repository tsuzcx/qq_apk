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

public class yli
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  ylj jdField_a_of_type_Ylj = new ylj();
  int[] jdField_a_of_type_ArrayOfInt = bhez.b(zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), zps.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  public yli(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public yky a(int paramInt)
  {
    if (a(paramInt)) {
      return (yky)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
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
      yky localyky;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561781, paramViewGroup, false);
        localObject2 = new ylh(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1);
        localObject1 = this.jdField_a_of_type_Ylj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, (blpw)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
        localyky = a(paramInt);
        if (localyky != null) {
          break label109;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (ylh)paramView.getTag();
        localObject1 = paramView;
        break;
        Object localObject3 = localyky.jdField_a_of_type_JavaLangString;
        Object localObject4;
        if ((localObject3 != null) && (!((String)localObject3).equals(((ylh)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localObject4 = ((wtt)wth.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((ylh)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            if (((localyky.jdField_a_of_type_Int == 14) || (localyky.jdField_a_of_type_Int == 13) || (localyky.jdField_a_of_type_Int == 16) || (localyky.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localyky.b)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localyky.b);
            }
            if (localyky.jdField_f_of_type_Int != 4) {
              break label676;
            }
            bool = true;
            Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
            ImageView localImageView = ((ylh)localObject2).jdField_a_of_type_AndroidWidgetImageView;
            float f1 = 50;
            TextView localTextView = ((ylh)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            float f2 = 13;
            float f3 = 5;
            if (!bool) {
              break label682;
            }
            localObject3 = String.valueOf(localyky.b);
            label291:
            xiz.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
          }
        }
        else
        {
          if (localyky.jdField_a_of_type_Int != 1) {
            break label688;
          }
          ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((ylh)localObject2).c.setVisibility(8);
          ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          label350:
          ((ylh)localObject2).d.setText(localyky.a());
          if (localyky.jdField_f_of_type_Int != 4) {
            break label1995;
          }
          localObject3 = bhlg.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localyky.b), true);
          ((ylh)localObject2).e.setText((CharSequence)localObject3);
          ((ylh)localObject2).e.setVisibility(0);
          ((ylh)localObject2).f.setVisibility(8);
          label422:
          if ((!TextUtils.isEmpty(localyky.b())) && (!localyky.b().equals(((ylh)localObject2).jdField_b_of_type_JavaLangString)))
          {
            ((ylh)localObject2).jdField_b_of_type_JavaLangString = localyky.b();
            localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130846902);
          }
        }
        try
        {
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "story_message";
          localObject4 = URLDrawable.getDrawable(localyky.b(), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject4).setDecodeHandler(bhez.j);
          ((ylh)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject4);
          if (localyky.jdField_a_of_type_Wur != null) {
            ((ylh)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localyky.jdField_a_of_type_Wur, -1, null);
          }
          if (localyky.jdField_a_of_type_Wuq != null) {
            ((ylh)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localyky.jdField_a_of_type_Wuq, -1, -1L, -1);
          }
          localObject3 = ((ylh)localObject2).jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject3).setVisibility(i);
              this.jdField_a_of_type_Ylj.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, paramInt, localyky, (blpw)localObject2, this);
              ((ylh)localObject2).a(paramInt);
              continue;
              ((ylh)localObject2).jdField_a_of_type_JavaLangString = null;
              break label227;
              label676:
              bool = false;
              break label239;
              label682:
              localObject3 = null;
              break label291;
              label688:
              if ((localyky.jdField_a_of_type_Int == 2) || (localyky.jdField_a_of_type_Int == 3))
              {
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713329));
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label350;
                }
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localyky));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 4)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131713321));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713307));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((ylh)localObject2).c.setVisibility(8);
                }
              }
              if (localyky.jdField_a_of_type_Int == 12)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localyky));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713308));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((ylh)localObject2).c.setVisibility(8);
                }
              }
              if ((localyky.jdField_a_of_type_Int == 14) || (localyky.jdField_a_of_type_Int == 13))
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localyky));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713309));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((ylh)localObject2).c.setVisibility(8);
                }
              }
              if (localyky.jdField_a_of_type_Int == 15)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localyky));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713330));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((ylh)localObject2).c.setVisibility(8);
                }
              }
              if ((localyky.jdField_a_of_type_Int == 16) || (localyky.jdField_a_of_type_Int == 17))
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localyky));
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localyky.jdField_a_of_type_Boolean)
                {
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713327));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((ylh)localObject2).c.setVisibility(8);
                }
              }
              if (localyky.jdField_a_of_type_Int == 5)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.j);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 6)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.jdField_e_of_type_JavaLangString);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 7)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.jdField_e_of_type_JavaLangString);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 8)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(2131698625);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 9)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.jdField_e_of_type_JavaLangString);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 10)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.jdField_e_of_type_JavaLangString);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 11)
              {
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localyky.jdField_e_of_type_JavaLangString);
                ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ylh)localObject2).c.setVisibility(8);
                ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localyky.jdField_a_of_type_Int == 18)
              {
                i = localyky.jdField_e_of_type_Int;
                localObject3 = null;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                for (localObject3 = anzj.a(2131713326);; localObject3 = "@" + (String)localObject3 + anzj.a(2131713323))
                {
                  ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                  ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((ylh)localObject2).c.setVisibility(8);
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localyky.jdField_a_of_type_Int == 19)
              {
                if (localyky.g)
                {
                  ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((ylh)localObject2).c.setVisibility(0);
                  ((ylh)localObject2).c.setText(anzj.a(2131713322));
                }
                for (;;)
                {
                  ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localyky.jdField_f_of_type_Boolean)
                  {
                    ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    ((ylh)localObject2).c.setVisibility(0);
                    ((ylh)localObject2).c.setText(anzj.a(2131713314));
                  }
                  else
                  {
                    ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localyky));
                    ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                    ((ylh)localObject2).c.setVisibility(8);
                  }
                }
              }
              ((ylh)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              ((ylh)localObject2).c.setVisibility(8);
              ((ylh)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label350;
              label1995:
              if (((localyky.jdField_f_of_type_Int == 99) || (localyky.jdField_f_of_type_Int == 104)) && (localyky.jdField_a_of_type_Int != 6) && (localyky.jdField_a_of_type_Int != 9))
              {
                ((ylh)localObject2).e.setText(localyky.k);
                ((ylh)localObject2).e.setVisibility(0);
                ((ylh)localObject2).f.setVisibility(8);
                break label422;
              }
              if (((localyky.jdField_a_of_type_Int == 13) || (localyky.jdField_a_of_type_Int == 14) || (localyky.jdField_a_of_type_Int == 16) || (localyky.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localyky.p)))
              {
                if ("QQ好友".equals(localyky.p)) {
                  ((ylh)localObject2).e.setVisibility(8);
                }
                for (;;)
                {
                  ((ylh)localObject2).f.setVisibility(8);
                  break;
                  ((ylh)localObject2).e.setText(localyky.p);
                  ((ylh)localObject2).e.setVisibility(0);
                }
              }
              ((ylh)localObject2).e.setVisibility(8);
              ((ylh)localObject2).f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((ylh)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject3);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561782, paramViewGroup, false);
      localObject1 = new ylg(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(localObject1);
      label2271:
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      ((ylg)localObject1).a(paramInt);
      localObject1 = paramView;
      break;
      localObject1 = (ylg)paramView.getTag();
      break label2271;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        ((ylg)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698610);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
        ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((ylg)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject2 = ((ylg)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130846514;; i = 2130846513)
        {
          ((ImageView)localObject2).setImageResource(i);
          break;
        }
        ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698610);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698610);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713310));
          continue;
          ((ylg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((ylg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131698610);
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
        case 2131370743: 
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
          yup.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */