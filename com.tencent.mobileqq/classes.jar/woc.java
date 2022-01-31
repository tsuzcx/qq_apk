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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class woc
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  wod jdField_a_of_type_Wod = new wod();
  int[] jdField_a_of_type_ArrayOfInt = bcyz.b(xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  public woc(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public wns a(int paramInt)
  {
    if (a(paramInt)) {
      return (wns)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
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
    boolean bool;
    label210:
    int i;
    if (a(paramInt))
    {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561505, paramViewGroup, false);
        paramViewGroup = new wob(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
        paramView = this.jdField_a_of_type_Wod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramViewGroup, -1);
        paramView.setTag(paramViewGroup);
      }
      wns localwns;
      for (;;)
      {
        localwns = a(paramInt);
        if (localwns != null) {
          break;
        }
        return paramView;
        paramViewGroup = (wob)paramView.getTag();
      }
      localObject1 = localwns.jdField_a_of_type_JavaLangString;
      Object localObject2;
      if ((localObject1 != null) && (!((String)localObject1).equals(paramViewGroup.jdField_a_of_type_JavaLangString)))
      {
        localObject2 = ((uwm)uwa.a(2)).b((String)localObject1);
        if (localObject2 == null) {
          break label618;
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = ((String)localObject1);
        if (((localwns.jdField_a_of_type_Int == 14) || (localwns.jdField_a_of_type_Int == 13) || (localwns.jdField_a_of_type_Int == 16) || (localwns.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localwns.b)))) {
          ((QQUserUIItem)localObject2).qq = String.valueOf(localwns.b);
        }
      }
      for (;;)
      {
        if (localwns.jdField_f_of_type_Int == 4)
        {
          bool = true;
          Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
          ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
          float f1 = 50;
          TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          float f2 = 13;
          float f3 = 5;
          if (!bool) {
            break label632;
          }
          localObject1 = String.valueOf(localwns.b);
          label260:
          vls.a(localResources, (QQUserUIItem)localObject2, localImageView, f1, localTextView, f2, f3, bool, (String)localObject1);
          if (localwns.jdField_a_of_type_Int != 1) {
            break label638;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label316:
          paramViewGroup.d.setText(localwns.a());
          if (localwns.jdField_f_of_type_Int != 4) {
            break label1862;
          }
          localObject1 = bdgc.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localwns.b), true);
          paramViewGroup.e.setText((CharSequence)localObject1);
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.f.setVisibility(8);
          label384:
          if ((!TextUtils.isEmpty(localwns.b())) && (!localwns.b().equals(paramViewGroup.jdField_b_of_type_JavaLangString)))
          {
            paramViewGroup.jdField_b_of_type_JavaLangString = localwns.b();
            localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130846447);
          }
        }
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "story_message";
          localObject2 = URLDrawable.getDrawable(localwns.b(), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject2).setDecodeHandler(bcyz.i);
          paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject2);
          if (localwns.jdField_a_of_type_Uxk != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localwns.jdField_a_of_type_Uxk, -1, null);
          }
          if (localwns.jdField_a_of_type_Uxj != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localwns.jdField_a_of_type_Uxj, -1, -1L, -1);
          }
          localObject1 = paramViewGroup.jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject1).setVisibility(i);
              this.jdField_a_of_type_Wod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramInt, localwns, paramViewGroup, this);
              paramViewGroup.a(paramInt);
              return paramView;
              label618:
              paramViewGroup.jdField_a_of_type_JavaLangString = null;
              continue;
              bool = false;
              break label210;
              label632:
              localObject1 = null;
              break label260;
              label638:
              if ((localwns.jdField_a_of_type_Int == 2) || (localwns.jdField_a_of_type_Int == 3))
              {
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714919));
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label316;
                }
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localwns));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 4)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131714911));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714897));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwns.jdField_a_of_type_Int == 12)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localwns));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714898));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localwns.jdField_a_of_type_Int == 14) || (localwns.jdField_a_of_type_Int == 13))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localwns));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714899));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwns.jdField_a_of_type_Int == 15)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localwns));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714920));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localwns.jdField_a_of_type_Int == 16) || (localwns.jdField_a_of_type_Int == 17))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localwns));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwns.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714917));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwns.jdField_a_of_type_Int == 5)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.j);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 6)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 7)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 8)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131700092);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 9)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 10)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 11)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwns.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwns.jdField_a_of_type_Int == 18)
              {
                i = localwns.jdField_e_of_type_Int;
                localObject1 = null;
                if (i > 0) {
                  localObject1 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                for (localObject1 = alud.a(2131714916);; localObject1 = "@" + (String)localObject1 + alud.a(2131714913))
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  paramViewGroup.c.setVisibility(8);
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localwns.jdField_a_of_type_Int == 19)
              {
                if (localwns.g)
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alud.a(2131714912));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localwns.jdField_f_of_type_Boolean)
                  {
                    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    paramViewGroup.c.setVisibility(0);
                    paramViewGroup.c.setText(alud.a(2131714904));
                  }
                  else
                  {
                    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localwns));
                    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                    paramViewGroup.c.setVisibility(8);
                  }
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              paramViewGroup.c.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label316;
              label1862:
              if (((localwns.jdField_f_of_type_Int == 99) || (localwns.jdField_f_of_type_Int == 104)) && (localwns.jdField_a_of_type_Int != 6) && (localwns.jdField_a_of_type_Int != 9))
              {
                paramViewGroup.e.setText(localwns.k);
                paramViewGroup.e.setVisibility(0);
                paramViewGroup.f.setVisibility(8);
                break label384;
              }
              if (((localwns.jdField_a_of_type_Int == 13) || (localwns.jdField_a_of_type_Int == 14) || (localwns.jdField_a_of_type_Int == 16) || (localwns.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localwns.p)))
              {
                if ("QQ好友".equals(localwns.p)) {
                  paramViewGroup.e.setVisibility(8);
                }
                for (;;)
                {
                  paramViewGroup.f.setVisibility(8);
                  break;
                  paramViewGroup.e.setText(localwns.p);
                  paramViewGroup.e.setVisibility(0);
                }
              }
              paramViewGroup.e.setVisibility(8);
              paramViewGroup.f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject1);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561506, paramViewGroup, false);
      paramViewGroup = new woa(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(paramViewGroup);
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (woa)paramView.getTag();
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700077);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130846058;; i = 2130846057)
        {
          ((ImageView)localObject1).setImageResource(i);
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700077);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700077);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714900));
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700077);
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
    int i;
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1) {
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
        i = -1;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
    wxj.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */