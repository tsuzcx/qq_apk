package com.tencent.token;

import android.os.Bundle;

public final class or
{
  public static final class a
    extends og
  {
    public ot c;
    public int d;
    public String e;
    
    public final int a()
    {
      return 2;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      ot localot = this.c;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", localot.a);
      localBundle.putString("_wxobject_title", localot.b);
      localBundle.putString("_wxobject_description", localot.c);
      localBundle.putByteArray("_wxobject_thumbdata", localot.d);
      if (localot.e != null)
      {
        String str2 = localot.e.getClass().getName();
        String str1 = str2;
        if (str2 != null) {
          if (str2.length() == 0) {
            str1 = str2;
          } else {
            str1 = str2.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
          }
        }
        localBundle.putString("_wxobject_identifier_", str1);
        localot.e.a(localBundle);
      }
      localBundle.putString("_wxobject_mediatagname", localot.f);
      localBundle.putString("_wxobject_message_action", localot.g);
      localBundle.putString("_wxobject_message_ext", localot.h);
      paramBundle.putAll(localBundle);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.d);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.c.a());
      paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = ot.a.a(paramBundle);
      this.d = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
      this.e = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
    }
    
    public final boolean b()
    {
      ot localot = this.c;
      if (localot == null) {
        return false;
      }
      if ((localot.e.a() == 6) && (this.d == 2)) {
        ((os)this.c.e).a = 26214400;
      }
      if ((this.d == 3) && (this.e == null)) {
        return false;
      }
      if ((this.d == 3) && (this.b == null)) {
        return false;
      }
      localot = this.c;
      if ((localot.a() == 8) && ((localot.d == null) || (localot.d.length == 0))) {
        return false;
      }
      if ((pg.a(localot.a())) && ((localot.d == null) || (localot.d.length > 131072))) {
        return false;
      }
      if ((!pg.a(localot.a())) && (localot.d != null) && (localot.d.length > 65536)) {
        return false;
      }
      if ((localot.b != null) && (localot.b.length() > 512)) {
        return false;
      }
      if ((localot.c != null) && (localot.c.length() > 1024)) {
        return false;
      }
      if (localot.e == null) {
        return false;
      }
      if ((localot.f != null) && (localot.f.length() > 64)) {
        return false;
      }
      if ((localot.g != null) && (localot.g.length() > 2048)) {
        return false;
      }
      if ((localot.h != null) && (localot.h.length() > 2048)) {
        return false;
      }
      return localot.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.or
 * JD-Core Version:    0.7.0.1
 */