package com.tencent.qqmail.activity.compose;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.alias.AliasItem;
import java.util.ArrayList;
import java.util.List;

class ComposeFeedbackActivity$9
  implements Runnable
{
  ComposeFeedbackActivity$9(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void run()
  {
    PickerViewControl localPickerViewControl = new PickerViewControl();
    localPickerViewControl.setGroup(false);
    localPickerViewControl.setTitle(this.this$0.getString(2131719404));
    ArrayList localArrayList = new ArrayList();
    List localList = ComposeFeedbackActivity.access$400();
    int i = 0;
    while (i < localList.size())
    {
      localObject1 = new AliasItem();
      ((AliasItem)localObject1).setAccountId(i);
      ((AliasItem)localObject1).setAlias(((String)localList.get(i)).split(" ")[0]);
      localArrayList.add(localObject1);
      i += 1;
    }
    Object localObject2 = (LinearLayout)this.this$0.findViewById(2131365165);
    ((LinearLayout)localObject2).setVisibility(0);
    Object localObject1 = (TextView)((LinearLayout)localObject2).findViewById(2131365191);
    String str = ((String)localList.get(0)).split(" ")[0];
    ((TextView)localObject1).setText(str);
    ((TextView)localObject1).setVisibility(0);
    ((TextView)localObject1).setOnClickListener(new ComposeFeedbackActivity.9.1(this));
    localObject2 = (TextView)((LinearLayout)localObject2).findViewById(2131365192);
    ((TextView)localObject2).setVisibility(0);
    ((TextView)localObject2).setText(QMApplicationContext.sharedInstance().getString(2131719406));
    localPickerViewControl.appendData(localArrayList);
    localPickerViewControl.setDefaultSelect(str);
    localPickerViewControl.setCallback(new ComposeFeedbackActivity.9.2(this, localList, (TextView)localObject1));
    localPickerViewControl.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.9
 * JD-Core Version:    0.7.0.1
 */