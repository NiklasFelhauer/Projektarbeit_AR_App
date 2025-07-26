package com.google.mediapipe.examples.objectdetection;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020&H\u0014J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\rJ\u0006\u00101\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R#\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f0\u001f8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_delegate", "", "_maxResults", "_model", "_mqttMessages", "Landroidx/lifecycle/MutableLiveData;", "", "", "_tankTemperatures", "", "", "_threshold", "brokerUri", "connected", "", "currentDelegate", "getCurrentDelegate", "()I", "currentMaxResults", "getCurrentMaxResults", "currentModel", "getCurrentModel", "currentThreshold", "getCurrentThreshold", "()F", "mqttClient", "Lorg/eclipse/paho/client/mqttv3/MqttClient;", "mqttMessages", "Landroidx/lifecycle/LiveData;", "getMqttMessages", "()Landroidx/lifecycle/LiveData;", "tankTemperatures", "getTankTemperatures", "topic", "addMessage", "", "msg", "onCleared", "setDelegate", "delegate", "setMaxResults", "maxResults", "setModel", "model", "setThreshold", "threshold", "startMqtt", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private int _delegate = 0;
    private float _threshold = 0.8F;
    private int _maxResults = 3;
    private int _model = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _mqttMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Float>> _tankTemperatures = null;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttClient mqttClient;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String brokerUri = "tcp://192.168.1.12:1883";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String topic = "mein/test/topic";
    private boolean connected = false;
    
    public MainViewModel() {
        super();
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final float getCurrentThreshold() {
        return 0.0F;
    }
    
    public final int getCurrentMaxResults() {
        return 0;
    }
    
    public final int getCurrentModel() {
        return 0;
    }
    
    public final void setDelegate(int delegate) {
    }
    
    public final void setThreshold(float threshold) {
    }
    
    public final void setMaxResults(int maxResults) {
    }
    
    public final void setModel(int model) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMqttMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Map<java.lang.String, java.lang.Float>> getTankTemperatures() {
        return null;
    }
    
    public final void startMqtt() {
    }
    
    private final void addMessage(java.lang.String msg) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}