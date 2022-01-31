package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import avz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;

public class MusicSharePlayActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  private Handler jdField_a_of_type_AndroidOsHandler = new avz(this);
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
    SongInfo localSongInfo = QQPlayerService.a();
    if (localSongInfo != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSongInfo.b);
      this.b.setText(localSongInfo.c);
      if (TextUtils.isEmpty(localSongInfo.d)) {
        break label106;
      }
    }
    label106:
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject = getResources().getDrawable(2130839434);
        localObject = URLDrawable.getDrawable(localSongInfo.d, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("IphoneTitleBarActivity", 2, "song.coverUrl: " + localSongInfo.d, localThrowable);
        return;
      }
    }
    QLog.e("IphoneTitleBarActivity", 2, "song.coverUrl is empty ");
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297321));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297322));
    this.b = ((TextView)findViewById(2131297323));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297324));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297324)
    {
      QQPlayerService.c(getApplicationContext());
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903243);
    setTitle(2131364127);
    setLeftViewName(2131364503);
    c();
    this.app.a(MusicSharePlayActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.a(MusicSharePlayActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MusicSharePlayActivity
 * JD-Core Version:    0.7.0.1
 */