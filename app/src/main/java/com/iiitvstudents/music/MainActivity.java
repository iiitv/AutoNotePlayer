package com.iiitvstudents.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Hashtable;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

public class MainActivity extends AppCompatActivity {
    public static final int no_samples=4;
    int i=0,mid;
    float[] data=new float[no_samples];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<NoteFrequency> notes=new ArrayList<>();
        notes.add(new NoteFrequency(16.35,"C 0"));
        notes.add(new NoteFrequency(17.32,"C# 0"));
        notes.add(new NoteFrequency(18.35,"D 0"));
        notes.add(new NoteFrequency(19.45,"D# 0"));
        notes.add(new NoteFrequency(20.60,"E 0"));
        notes.add(new NoteFrequency(21.83,"F 0"));
        notes.add(new NoteFrequency(23.12,"F# 0"));
        notes.add(new NoteFrequency(24.50,"G 0"));
        notes.add(new NoteFrequency(25.96,"G# 0"));
        notes.add(new NoteFrequency(27.50,"A 0"));
        notes.add(new NoteFrequency(29.14,"A# 0"));
        notes.add(new NoteFrequency(30.87,"B 0"));
        notes.add(new NoteFrequency(32.70,"C 1"));
        notes.add(new NoteFrequency(34.65,"C# 1"));
        notes.add(new NoteFrequency(36.71,"D 1"));
        notes.add(new NoteFrequency(38.89,"D# 1"));
        notes.add(new NoteFrequency(41.20,"E 1"));
        notes.add(new NoteFrequency(43.65,"F 1"));
        notes.add(new NoteFrequency(46.25,"F# 1"));
        notes.add(new NoteFrequency(49.00,"G 1"));
        notes.add(new NoteFrequency(51.91,"G# 1"));
        notes.add(new NoteFrequency(55.00,"A 1"));
        notes.add(new NoteFrequency(58.27,"A# 1"));
        notes.add(new NoteFrequency(61.74,"B 1"));
        notes.add(new NoteFrequency(65.41,"C 2"));
        notes.add(new NoteFrequency(69.30,"C# 2"));
        notes.add(new NoteFrequency(73.42,"D 2"));
        notes.add(new NoteFrequency(77.78,"D# 2"));
        notes.add(new NoteFrequency(82.41,"E 2"));
        notes.add(new NoteFrequency(87.31,"F 2"));
        notes.add(new NoteFrequency(92.50,"F# 2"));
        notes.add(new NoteFrequency(98.00,"G 2"));
        notes.add(new NoteFrequency(103.83,"G# 2"));
        notes.add(new NoteFrequency(110.00,"A 2"));
        notes.add(new NoteFrequency(116.54,"A# 2"));
        notes.add(new NoteFrequency(123.47,"B 2"));
        notes.add(new NoteFrequency(130.81,"C 3"));
        notes.add(new NoteFrequency(138.59,"C# 3"));
        notes.add(new NoteFrequency(146.83,"D 3"));
        notes.add(new NoteFrequency(155.56,"D# 3"));
        notes.add(new NoteFrequency(164.81,"E 3"));
        notes.add(new NoteFrequency(174.61,"F 3"));
        notes.add(new NoteFrequency(185.00,"F# 3"));
        notes.add(new NoteFrequency(196.00,"G 3"));
        notes.add(new NoteFrequency(207.65,"G# 3"));
        notes.add(new NoteFrequency(220.00,"A 3"));
        notes.add(new NoteFrequency(233.08,"A# 3"));
        notes.add(new NoteFrequency(246.94,"B 3"));
        notes.add(new NoteFrequency(261.63,"C 4"));
        notes.add(new NoteFrequency(277.18,"C# 4"));
        notes.add(new NoteFrequency(293.66,"D 4"));
        notes.add(new NoteFrequency(311.13,"D# 4"));
        notes.add(new NoteFrequency(329.63,"E 4"));
        notes.add(new NoteFrequency(349.23,"F 4"));
        notes.add(new NoteFrequency(369.99,"F# 4"));
        notes.add(new NoteFrequency(392.00,"G 4"));
        notes.add(new NoteFrequency(415.30,"G# 4"));
        notes.add(new NoteFrequency(440.00,"A 4"));
        notes.add(new NoteFrequency(466.16,"A# 4"));
        notes.add(new NoteFrequency(493.88,"B 4"));
        notes.add(new NoteFrequency(523.25,"C 5"));
        notes.add(new NoteFrequency(554.37,"C# 5"));
        notes.add(new NoteFrequency(587.33,"D 5"));
        notes.add(new NoteFrequency(622.25,"D# 5"));
        notes.add(new NoteFrequency(659.25,"E 5"));
        notes.add(new NoteFrequency(698.46,"F 5"));
        notes.add(new NoteFrequency(739.99,"F# 5"));
        notes.add(new NoteFrequency(783.99,"G 5"));
        notes.add(new NoteFrequency(830.61,"G# 5"));
        notes.add(new NoteFrequency(880.00,"A 5"));
        notes.add(new NoteFrequency(932.33,"A# 5"));
        notes.add(new NoteFrequency(987.77,"B 5"));
        notes.add(new NoteFrequency(1046.50,"C 6"));
        notes.add(new NoteFrequency(1108.73,"C# 6"));
        notes.add(new NoteFrequency(1174.66,"D 6"));
        notes.add(new NoteFrequency(1244.51,"D# 6"));
        notes.add(new NoteFrequency(1318.51,"E 6"));
        notes.add(new NoteFrequency(1396.91,"F 6"));
        notes.add(new NoteFrequency(1479.98,"F# 6"));
        notes.add(new NoteFrequency(1567.98,"G 6"));
        notes.add(new NoteFrequency(1661.22,"G# 6"));
        notes.add(new NoteFrequency(1760.00,"A 6"));
        notes.add(new NoteFrequency(1864.66,"A# 6"));
        notes.add(new NoteFrequency(1975.53,"B 6"));
        notes.add(new NoteFrequency(2093.00,"C 7"));
        notes.add(new NoteFrequency(2217.46,"C# 7"));
        notes.add(new NoteFrequency(2349.32,"D 7"));
        notes.add(new NoteFrequency(2489.02,"D# 7"));
        notes.add(new NoteFrequency(2637.02,"E 7"));
        notes.add(new NoteFrequency(2793.83,"F 7"));
        notes.add(new NoteFrequency(2959.96,"F# 7"));
        notes.add(new NoteFrequency(3135.96,"G 7"));
        notes.add(new NoteFrequency(3322.44,"G# 7"));
        notes.add(new NoteFrequency(3520.00,"A 7"));
        notes.add(new NoteFrequency(3729.31,"A# 7"));
        notes.add(new NoteFrequency(3951.07,"B 7"));
        notes.add(new NoteFrequency(4186.01,"C 8"));
        notes.add(new NoteFrequency(4434.92,"C# 8"));
        notes.add(new NoteFrequency(4698.63,"D 8"));
        notes.add(new NoteFrequency(4978.03,"D# 8"));
        notes.add(new NoteFrequency(5274.04,"E 8"));
        notes.add(new NoteFrequency(5587.65,"F 8"));
        notes.add(new NoteFrequency(5919.91,"F# 8"));
        notes.add(new NoteFrequency(6271.93,"G 8"));
        notes.add(new NoteFrequency(6644.88,"G# 8"));
        notes.add(new NoteFrequency(7040.00,"A 8"));
        notes.add(new NoteFrequency(7458.62,"A# 8"));
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            float sum=0;
            float mean_data;
            @Override
            public void handlePitch(PitchDetectionResult result,AudioEvent e) {
                final float pitchInHz = result.getPitch();
                Log.e("pitch",pitchInHz+"");
                data[i++%no_samples]=pitchInHz;
                sum+=pitchInHz;
                if(i>=no_samples){
//                    for (int j = 0; j <no_samples ; j++) {
//                        sum=sum+data[j];
//                    }
//                    i=0;
                     mean_data=sum/no_samples;
                    sum-=data[(i)%no_samples];
                    Log.e("Mean_data",""+mean_data);
                    int start=0;
                    int end=notes.size()-1;
                    mid=(start+end)/2;
                    while (mid!=end&&mid!=start){
                        if(notes.get(mid).frequency<=mean_data){
                            Log.e("fas",start+" "+end+" "+mid);
                            start=mid;
                            mid=(start+end)/2;
                        }else{
                            Log.e("fasfas",start+" "+end+" "+mid);
                            end=mid;
                            mid=(start+end)/2;
                        }
                    }
                    if(Math.abs(mean_data-notes.get(start).frequency)<Math.abs(mean_data-notes.get(end).frequency)){
                        mid=start;
                    }
                    else
                        mid=end;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView disp=(TextView)findViewById(R.id.textView);
                        disp.setText(""+notes.get(mid).note);
                        TextView text = (TextView) findViewById(R.id.textView1);
                        text.setText("" +mean_data+"Hz");
                    }
                });
            }
        };
        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher,"Audio Dispatcher").start();
    }
}
