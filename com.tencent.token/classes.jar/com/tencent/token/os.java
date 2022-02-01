package com.tencent.token;

import android.os.Bundle;

public final class os
{
  public static final class a
    extends oh
  {
    public ou c;
    public int d;
    public String e;
    
    public final int a()
    {
      return 2;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      ou localou = this.c;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", localou.a);
      localBundle.putString("_wxobject_title", localou.b);
      localBundle.putString("_wxobject_description", localou.c);
      localBundle.putByteArray("_wxobject_thumbdata", localou.d);
      if (localou.e != null)
      {
        String str2 = localou.e.getClass().getName();
        String str1 = str2;
        if (str2 != null) {
          if (str2.length() == 0) {
            str1 = str2;
          } else {
            str1 = str2.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
          }
        }
        localBundle.putString("_wxobject_identifier_", str1);
        localou.e.a(localBundle);
      }
      localBundle.putString("_wxobject_mediatagname", localou.f);
      localBundle.putString("_wxobject_message_action", localou.g);
      localBundle.putString("_wxobject_message_ext", localou.h);
      paramBundle.putAll(localBundle);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.d);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.c.a());
      paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = ou.a.a(paramBundle);
      this.d = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
      this.e = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
    }
    
    public final boolean b()
    {
      ou localou = this.c;
      if (localou == null) {
        return false;
      }
      if ((localou.e.a() == 6) && (this.d == 2)) {
        ((ot)this.c.e).a = 26214400;
      }
      if ((this.d == 3) && (this.e == null)) {
        return false;
      }
      if ((this.d == 3) && (this.b == null)) {
        return false;
      }
      localou = this.c;
      if ((localou.a() == 8) && ((localou.d == null) || (localou.d.length == 0))) {
        return false;
      }
      if ((ph.a(localou.a())) && ((localou.d == null) || (localou.d.length > 131072))) {
        return false;
      }
      if ((!ph.a(localou.a())) && (localou.d != null) && (localou.d.length > 65536)) {
        return false;
      }
      if ((localou.b != null) && (localou.b.length() > 512)) {
        return false;
      }
      if ((localou.c != null) && (localou.c.length() > 1024)) {
        return false;
      }
      if (localou.e == null) {
        return false;
      }
      if ((localou.f != null) && (localou.f.length() > 64)) {
        return false;
      }
      if ((localou.g != null) && (localou.g.length() > 2048)) {
        return false;
      }
      if ((localou.h != null) && (localou.h.length() > 2048)) {
        return false;
      }
      return localou.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.os
 * JD-Core Version:    0.7.0.1
 */