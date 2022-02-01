package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import prw.a;
import rcl;
import rdc;

public class EditVideoFilterNeo$3
  implements Runnable
{
  public EditVideoFilterNeo$3(rcl paramrcl, prw.a parama) {}
  
  public void run()
  {
    this.this$0.b.a(Message.obtain(null, 5, 0, 0, this.a));
    String str;
    if (TextUtils.isEmpty(this.a.city)) {
      if (TextUtils.isEmpty(this.a.province)) {
        str = this.a.country;
      }
    }
    for (;;)
    {
      this.this$0.b.a.mExtra.putString("extra_local_address_city_name", str);
      return;
      str = this.a.province;
      continue;
      str = this.a.city;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.3
 * JD-Core Version:    0.7.0.1
 */