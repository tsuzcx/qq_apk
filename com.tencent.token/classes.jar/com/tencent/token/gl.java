package com.tencent.token;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.a;
import okhttp3.ae;
import okhttp3.au;
import okhttp3.ax;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.g;
import okhttp3.o;
import okhttp3.q;

public abstract class gl
{
  public static gl a;
  
  public abstract int a(au paramau);
  
  public abstract Socket a(o paramo, a parama, g paramg);
  
  public abstract c a(o paramo, a parama, g paramg, ax paramax);
  
  public abstract d a(o paramo);
  
  public abstract void a(ae paramae, String paramString);
  
  public abstract void a(ae paramae, String paramString1, String paramString2);
  
  public abstract void a(q paramq, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract boolean a(a parama1, a parama2);
  
  public abstract boolean a(o paramo, c paramc);
  
  public abstract void b(o paramo, c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gl
 * JD-Core Version:    0.7.0.1
 */