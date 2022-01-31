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

public class wjt
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  wju jdField_a_of_type_Wju = new wju();
  int[] jdField_a_of_type_ArrayOfInt = bcuq.b(xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), xod.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  public wjt(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public wjj a(int paramInt)
  {
    if (a(paramInt)) {
      return (wjj)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561487, paramViewGroup, false);
        paramViewGroup = new wjs(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
        paramView = this.jdField_a_of_type_Wju.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramViewGroup, -1);
        paramView.setTag(paramViewGroup);
      }
      wjj localwjj;
      for (;;)
      {
        localwjj = a(paramInt);
        if (localwjj != null) {
          break;
        }
        return paramView;
        paramViewGroup = (wjs)paramView.getTag();
      }
      localObject1 = localwjj.jdField_a_of_type_JavaLangString;
      Object localObject2;
      if ((localObject1 != null) && (!((String)localObject1).equals(paramViewGroup.jdField_a_of_type_JavaLangString)))
      {
        localObject2 = ((usd)urr.a(2)).b((String)localObject1);
        if (localObject2 == null) {
          break label618;
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = ((String)localObject1);
        if (((localwjj.jdField_a_of_type_Int == 14) || (localwjj.jdField_a_of_type_Int == 13) || (localwjj.jdField_a_of_type_Int == 16) || (localwjj.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localwjj.b)))) {
          ((QQUserUIItem)localObject2).qq = String.valueOf(localwjj.b);
        }
      }
      for (;;)
      {
        if (localwjj.jdField_f_of_type_Int == 4)
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
          localObject1 = String.valueOf(localwjj.b);
          label260:
          vhj.a(localResources, (QQUserUIItem)localObject2, localImageView, f1, localTextView, f2, f3, bool, (String)localObject1);
          if (localwjj.jdField_a_of_type_Int != 1) {
            break label638;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label316:
          paramViewGroup.d.setText(localwjj.a());
          if (localwjj.jdField_f_of_type_Int != 4) {
            break label1862;
          }
          localObject1 = bdbt.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localwjj.b), true);
          paramViewGroup.e.setText((CharSequence)localObject1);
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.f.setVisibility(8);
          label384:
          if ((!TextUtils.isEmpty(localwjj.b())) && (!localwjj.b().equals(paramViewGroup.jdField_b_of_type_JavaLangString)))
          {
            paramViewGroup.jdField_b_of_type_JavaLangString = localwjj.b();
            localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130846374);
          }
        }
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "story_message";
          localObject2 = URLDrawable.getDrawable(localwjj.b(), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject2).setDecodeHandler(bcuq.i);
          paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject2);
          if (localwjj.jdField_a_of_type_Utb != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localwjj.jdField_a_of_type_Utb, -1, null);
          }
          if (localwjj.jdField_a_of_type_Uta != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localwjj.jdField_a_of_type_Uta, -1, -1L, -1);
          }
          localObject1 = paramViewGroup.jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject1).setVisibility(i);
              this.jdField_a_of_type_Wju.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramInt, localwjj, paramViewGroup, this);
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
              if ((localwjj.jdField_a_of_type_Int == 2) || (localwjj.jdField_a_of_type_Int == 3))
              {
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714907));
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label316;
                }
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localwjj));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 4)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131714899));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714885));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwjj.jdField_a_of_type_Int == 12)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localwjj));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714886));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localwjj.jdField_a_of_type_Int == 14) || (localwjj.jdField_a_of_type_Int == 13))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localwjj));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714887));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwjj.jdField_a_of_type_Int == 15)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localwjj));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714908));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localwjj.jdField_a_of_type_Int == 16) || (localwjj.jdField_a_of_type_Int == 17))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localwjj));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localwjj.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714905));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localwjj.jdField_a_of_type_Int == 5)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.j);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 6)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 7)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 8)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131700080);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 9)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 10)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 11)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localwjj.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localwjj.jdField_a_of_type_Int == 18)
              {
                i = localwjj.jdField_e_of_type_Int;
                localObject1 = null;
                if (i > 0) {
                  localObject1 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject1)) {}
                for (localObject1 = alpo.a(2131714904);; localObject1 = "@" + (String)localObject1 + alpo.a(2131714901))
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  paramViewGroup.c.setVisibility(8);
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localwjj.jdField_a_of_type_Int == 19)
              {
                if (localwjj.g)
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText(alpo.a(2131714900));
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localwjj.jdField_f_of_type_Boolean)
                  {
                    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    paramViewGroup.c.setVisibility(0);
                    paramViewGroup.c.setText(alpo.a(2131714892));
                  }
                  else
                  {
                    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localwjj));
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
              if (((localwjj.jdField_f_of_type_Int == 99) || (localwjj.jdField_f_of_type_Int == 104)) && (localwjj.jdField_a_of_type_Int != 6) && (localwjj.jdField_a_of_type_Int != 9))
              {
                paramViewGroup.e.setText(localwjj.k);
                paramViewGroup.e.setVisibility(0);
                paramViewGroup.f.setVisibility(8);
                break label384;
              }
              if (((localwjj.jdField_a_of_type_Int == 13) || (localwjj.jdField_a_of_type_Int == 14) || (localwjj.jdField_a_of_type_Int == 16) || (localwjj.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localwjj.p)))
              {
                if ("QQ好友".equals(localwjj.p)) {
                  paramViewGroup.e.setVisibility(8);
                }
                for (;;)
                {
                  paramViewGroup.f.setVisibility(8);
                  break;
                  paramViewGroup.e.setText(localwjj.p);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561488, paramViewGroup, false);
      paramViewGroup = new wjr(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(paramViewGroup);
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (wjr)paramView.getTag();
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700065);
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
        for (i = 2130845985;; i = 2130845984)
        {
          ((ImageView)localObject1).setImageResource(i);
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700065);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700065);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131714888));
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131700065);
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
    wta.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjt
 * JD-Core Version:    0.7.0.1
 */