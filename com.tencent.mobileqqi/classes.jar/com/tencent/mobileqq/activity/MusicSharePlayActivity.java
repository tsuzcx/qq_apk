package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import cwk;

public class MusicSharePlayActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  private Handler jdField_a_of_type_AndroidOsHandler = new cwk(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQPlayerService a;
  private TextView b;
  
  public MusicSharePlayActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService = null;
  }
  
  private void d()
  {
    Object localObject = QQPlayerService.a();
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((SongInfo)localObject).b);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((SongInfo)localObject).c);
      Drawable localDrawable = getResources().getDrawable(2130840245);
      localObject = URLDrawable.getDrawable(((SongInfo)localObject).d, localDrawable, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  protected boolean b()
  {
    return super.b();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231951));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231952));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231953));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231954));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231954)
    {
      QQPlayerService.c(getApplicationContext());
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903289);
    setTitle(2131562287);
    h(2131560958);
    c();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(MusicSharePlayActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(MusicSharePlayActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MusicSharePlayActivity
 * JD-Core Version:    0.7.0.1
 */