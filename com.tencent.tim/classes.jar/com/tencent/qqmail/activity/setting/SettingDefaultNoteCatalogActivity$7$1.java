package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.movenote.MoveNoteAdapter;
import java.util.HashMap;

class SettingDefaultNoteCatalogActivity$7$1
  implements Runnable
{
  SettingDefaultNoteCatalogActivity$7$1(SettingDefaultNoteCatalogActivity.7 param7, Object paramObject) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    QMNNoteCategory localQMNNoteCategory = (QMNNoteCategory)this.val$data;
    localHashMap.put("id", localQMNNoteCategory.getCatalogId());
    localHashMap.put("name", localQMNNoteCategory.getCatalogName());
    SettingDefaultNoteCatalogActivity.access$500(this.this$1.this$0).add(localHashMap);
    SettingDefaultNoteCatalogActivity.access$500(this.this$1.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingDefaultNoteCatalogActivity.7.1
 * JD-Core Version:    0.7.0.1
 */