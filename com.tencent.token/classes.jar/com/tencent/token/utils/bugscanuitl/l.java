package com.tencent.token.utils.bugscanuitl;

import android.content.Intent;

final class l
  implements q
{
  l(ResultListActivity paramResultListActivity) {}
  
  public final void a()
  {
    Intent localIntent = new Intent(this.a, DetectActivity.class);
    localIntent.putExtra("result", this.a.result);
    localIntent.putExtra("result_flag", 1);
    localIntent.setFlags(67108864);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.l
 * JD-Core Version:    0.7.0.1
 */