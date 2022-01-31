package com.tencent.token.ui;

import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.d;
import java.util.ArrayList;

final class mw
  extends bo
{
  mw(JLAppealListActivity paramJLAppealListActivity)
  {
    super(paramJLAppealListActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.pb.setVisibility(8);
      if (paramMessage.arg1 != 0) {
        break;
      }
      JLAppealListActivity.access$002(this.a, (ArrayList)paramMessage.obj);
      JLAppealListActivity.access$100(this.a).notifyDataSetChanged();
    } while ((JLAppealListActivity.access$000(this.a) != null) && (JLAppealListActivity.access$000(this.a).size() != 0));
    JLAppealListActivity.access$200(this.a).setVisibility(8);
    this.a.ll.setVisibility(0);
    return;
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.setContentView(2130903121);
    ImageView localImageView = (ImageView)this.a.findViewById(2131296766);
    this.a.findViewById(2131296767);
    TextView localTextView = (TextView)this.a.findViewById(2131296768);
    Button localButton = (Button)this.a.findViewById(2131296769);
    localButton.setText(2131362762);
    localButton.setOnClickListener(new mx(this));
    localImageView.setImageResource(2130837569);
    localTextView.setText(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mw
 * JD-Core Version:    0.7.0.1
 */