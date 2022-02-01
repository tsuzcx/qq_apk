package com.facebook.stetho.inspector.elements;

class Document$1
  implements Runnable
{
  Document$1(Document paramDocument) {}
  
  public void run()
  {
    Document.access$102(this.this$0, new ShadowDocument(Document.access$200(this.this$0).getRootElement()));
    Document.access$300(this.this$0).commit();
    Document.access$200(this.this$0).setListener(new Document.ProviderListener(this.this$0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document.1
 * JD-Core Version:    0.7.0.1
 */