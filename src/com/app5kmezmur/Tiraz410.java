package com.app5kmezmur;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import android.R.drawable;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import com.app5kmezmur.R;


public class Tiraz410 extends Activity {
	Button button4, button5, button6;
	CheckBox ch;
	List<String> ChildList;
	Map<String, List<String>> ParentListItems;
	ExpandableListView expandablelistView;
	// Assign Parent list items here.
	List<String> ParentList = new ArrayList<String>();
	{
		ParentList.add("181.	ነፍሴ ሆይ ");
		ParentList.add("182.	በሕይወቴ በዘመኔ ");
		ParentList.add("183.	የሰው ልጅ በኃይልህ ");
		ParentList.add("184.	 አምላክህን ውደድ ");
		ParentList.add("185.	ፈጣሪህን አስብ ");
		ParentList.add("186.	አይተወኝም");
		ParentList.add("187.	እርዳኝ ዝም አትበል ");

	}
	// Assign children list element using string array.

	String[] n181 = { "ነፍሴ ሆይ /፪/ እግዚአብሔርን በቅን አገልግይ /፪/\nየተቀበለው በቀራንዮ ያን ሁሉ በመስቀሉ ላይ\nለአንቺ ሲል ነው ነፍሴ ሆይ\n   አዝ...\nተዘጋጅተሽ ኑሪ ሁል ጊዜ በነገ በዛሬ \nእንዳትታለይ /፪/ ነፍሴ ሆይ\n   አዝ...\nበንሰሀ ጥምቀት ታጠቢና ክቡር ደሙን ጠጪ\nስጋውንም ብይ /፪/ ነፍሴ ሆይ\n   አዝ...\nዘለዓለም በደስታ እንድትኖሪ ከዘለዓለም ቤትሽ \nመንግስተ ሰማይ /፪/ ነፍሴ ሆይ\n   አዝ.../፫/ " },
			n182 = { "ሕይወቴ ሲመራ ጌታ በቃልህ\nብርታት አገኛለሁ ሲያድሰኝ ፍቅርህ\nየአንተ ጸጋ ጌታ ስለበዛልኝ\nጨለማው ተገፎ ብርሃንህ መራኝ\nበሕይወቴ በዘመኔ ደስ የሚለኝ ለእኔ\nበወንጌል ማመኔ\nወዴት እሄዳለሁ የእጅህ ጥበብ ሆኜ\nፍቅርህ እያደሰኝ ሞተህልኝ ድኜ\nምን ዓይነት መውደድ ነው አንተ ለኔ ያለህ\nምን ይከፈልሀል ለፍጹሙ ፍቅርህ\n    አዝ...\nምን ዓይነት መውደድ ነው አንተ ለእኔ ያለህ\nምን ይከፈለዋል ለፍጹሙ ፍቅርህ\nደጅህ ላይ ተጥዬ ደጅህ ላይ ልሙት\nቃልህን ልጠብቅ በፍፁም ፍርሃት" },
			n183 = { "የሰው ልጅ በኃይልህ ፈጽሞ አትመካ /፬/\nአንድ አምላክ አለና በኃይሉ ኃይልን የሚለካ /፪/\nኃይል እንደ ሶምሶን ከአምላክ ሲሰጥ እንጂ /፪/\nበጉልበት መመካት ለማንም አይበጅ /፪/\nሰናክሬም ቢነሳ በሕዝቅያስ ላይ /፪/\nየደረሰበትን አልሰማህም ወይ /፪/\nጎልያድ በኃይሉ ዳዊትን ቢንቀው /፪/\nአዋረደው እንጂ ኃይሉ መች ጠቀመው /፪/\nእንደ ዳታንና እንደ አቤሮን አይሆንም በግድ/፪/ /፪/ \nተመርጦ ነው እንጂ ለክብር በአምላከ ፈቃድ /፪/\n   አዝ...\nክህነትን ለአሮን ሕግንም ለሙሴ /፪/\nከሰው ሁሉ መርጠው ሰጧቸው ሥላሴ /፪/" },
			n184 = { "በደልህን አምነህ ንስሐ ግባና\nወደ አምላክህ አልቅስ ተጸጸትና \nአመስግነው ጌታን አፍቅረው ከልብህ\nበጉብዝናህ ወራት በሱ ደስ ይበልህ\n     ስትቸገር አይቶ ንቆ የማይተውህ\n     አምላክህን ውደድ እሱ ነው አለኝታህ /፪/\nየኀጢአት ኑሮን አቁምና ዛሬ\nለማፍራት ተነሣ የንስሐ ፍሬ\nየእግዚአብሔርን ድምጽ አትናቅ ጥሪውን\nተመለስ ይልሃል አስተውል መንገዱን\n   አዝ...\nየጉብዝናህ ወራት ያበቃል ያከትማል\nድካም መሸነፍ መውደቅም ይመጣል\nተስፋህ ይጨልማል ንብረትህም ያልቃል\nወጣትነትህስ መች ሁሌ ይኖራል\n   አዝ...\nየወደቅህ ለታ ማንም አያይህም\nሁሉም ሲኖርህ ነው ከአንተ ጋር አይቆምም\nእስከ መቼ ድረስ እንዲህ ትኖራለህ \nመለከት ሲነፋ ወዴት ትገባለህ\n   አዝ...\nለካህኑ ነግረህ የሰራኸውን ኀጢአት\nቀኖና ተቀበል እንድታገኝ ስርየት\nቤትህን አዘጋጅ ክርስቶስ ይመጣል\nማድጋህን ክፈት እሱ ይሞላዋል\n   አዝ...\nተመለስ ወደ እርሱ በደሙ ገዝቶሃል\nእርሱም አይቀየር ሊቀበልህ ወጥቷል\nአመስግነው ጌታን አፍቅረው ከልብህ\nበጉብዝናህ ወራት በእርሱ ደስ ይበልህ\n   አዝ..." },
			n185 = { "ፈጣሪህን አስብ በወጣትነትህ \nከፊቱ ተንበርከክ ሳይደክም ጉልበትህ \nሳትውል ሳታድር አሁኑኑ ተነሥ \nበጉብዝናህ ወራት አምላክህን አስታውስ \nጊዜህ አሁን ሆኖ /፪/ ብርቱ ሆነህ ሳለህ \nነገን አታውቃትም /፪/ እንደምትኖርባት \nይልቅስ ነቃ በል /፪/ ዛሬዋን ሥራባት \n\nቤትህን ውደዳት /፪/ ሃይማኖትህን ጠብቅ \nቅናት ምቀኝነት /፪/ ዝሙት ከአንተ ይራቅ \nየሥጋ ሥራን /፪/ ጥለህ ርኩሰትን \nእንደ እባብ ብልህ /፪/ እንደ ርግብ የዋህ ሁን \n\nቤተ ክርስቲያን /፪/ ቤተ እግዚአብሔር \nአለኝታ ሁንላት /፪/ ቅዱስ ቃሉን አክብር \nአደራ ክርስቲያን /፪/ ወጣት ሆይ አደራ \nየአበው ቃል ይከበር /፪/ መልካም ፍሬን አፍራ " },
			n186 = { "አምላኬ እግዚአብሔር አይተወኝም /፪/\nወድቄም አልቀርም\n   አዝ...\nለመንገዴም ብርሃን የእግሬ መብራት\nእረኛዬ እርሱ ነው አምላከ ምሕረት\nጠርቶ ያሳደረኝ በለመለመ መስክ\nአምላኬ እግዚአብሔር መንግሥቱ ትባረክ\n   አዝ...\nበዕርፍት ውሃ ዘንድ ነፍሴን የሚመራ\nያድነኛል እርሱ ከጭንቅ ከመከራ\nመታመኛዬ ነው የሚያሳጣኝ የለም\nእርሱ ከኔ ጋር ነው ወድቄም አልቀርም\n   አዝ...\nበትሩና ምርኩዙ እኔን ያጽናኑኛል\nምሕረት ቸርነቱ ሁሌ ይከተሉኛል\nኃጢአት በዝቶብኝ ሰዎች ቢጠሉኝም\nአምላኬ አይተወኝም ወድቄም አልቀርም\n   አዝ..." },
			n187 = { "	እርዳኝ ዝም አትበል የሠራዊት ጌታ \n	ተስፋ እንደሌለው ሰው ልቤ አያመንታ \n	አንተን ለማገልገል የነበረኝ ብርታት \n	ዛሬስ ተስኖኛል አቅቶኛል መትጋት \nጨንቆኝ እጣራለሁ ጸጋ አጥታ ሕይወቴ \nእባክህ አርመኝ እርዳኝ መድኃኒቴ \nልቤ ድንጋይ ሆኖ ቃልህ አልሰበረው \nየእጅህን ሥራ ጌታዬ አትናቀው\n   አዝ.... \nየክርስትና ኑሮ ሥርዓቱን አፍርሼ \nአለቅሳለሁ ጌታ በኃጢአት ተከስሼ \nሰላምና ፍቅር ነበር ክርስትና \nእኔ ግን ተናወጽኩ አልጸናሁምና \n   አዝ.... \nሥራዬና ቃልህ አልገናኝ አሉኝ \nበጠማማው ልቤ አንተን አሳዘንኩኝ \nጽኑ መሠረት ነህ የሕይወት አለት \nእኔ ግን ተናወጽኩ አቃተኝ መትጋት \n   አዝ.... \nበዕረፍት ውኃ ዘንድ በለመለመ ሳር \nበጎችህን ሁሉ በፍቅር የምታኖር \nይቅር በለኝና አምላኬ እግዚአብሔር\nከደጅህ ተጥዬ ለስምህ ልዘምር" };
	String[] ByDefalutMessage = { "መዝሙር የለውም!" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		ParentListItems = new LinkedHashMap<String, List<String>>();
		for (String HoldItem : ParentList) {
			if (HoldItem.equals("181.	ነፍሴ ሆይ ")) {
				loadChild(n181);
			} else if (HoldItem.equals("182.	በሕይወቴ በዘመኔ ")) {
				loadChild(n182);
			} else if (HoldItem.equals("183.	የሰው ልጅ በኃይልህ ")) {
				loadChild(n183);
			} else if (HoldItem.equals("184.	 አምላክህን ውደድ ")) {
				loadChild(n184);
			} else if (HoldItem.equals("185.	ፈጣሪህን አስብ ")) {
				loadChild(n185);
			} else if (HoldItem.equals("186.	አይተወኝም")) {
				loadChild(n186);
			} else if (HoldItem.equals("187.	እርዳኝ ዝም አትበል ")) {
				loadChild(n187);
			}

			else
				loadChild(ByDefalutMessage);
			ParentListItems.put(HoldItem, ChildList);
		}

		expandablelistView = (ExpandableListView) findViewById(R.id.expandableListView1);
		final ExpandableListAdapter expListAdapter = new T410(this,
				ParentList, ParentListItems);
		expandablelistView.setAdapter(expListAdapter);
		expandablelistView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				return true;
			}
		});

		TextView text = new TextView(this);
		text.setText("መዝሙረ ንስሐ");
		text.setTextSize(14);
		
		text.setTypeface(Typeface.createFromAsset(this.getAssets(),"fonts/gfzemenu.ttf"));
		text.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getActionBar().setCustomView(text);
		ColorDrawable col = new ColorDrawable(Color.parseColor("#365674"));
		getActionBar().setBackgroundDrawable(col);
		getActionBar().setIcon(R.drawable.ic_arrow_back_white2);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		expandablelistView
		.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub
				for (int i = 0; i < expListAdapter.getGroupCount(); i++) {

					if (i != groupPosition) {
						expandablelistView.collapseGroup(i);

					}
				}

			}
				});
		

	}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// API 5+ solution
			onBackPressed();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	private void loadChild(String[] ParentElementsName) {
		ChildList = new ArrayList<String>();
		for (String model : ParentElementsName)
			ChildList.add(model);
	}
	public class T410 extends BaseExpandableListAdapter {

		TextView duratio;
		private Activity context;
		Button play, playpause;
		SeekBar seekBar;
		Handler mHandler = new Handler();
		TextView currentduration, totalduration;
		private MediaPlayer mp = new MediaPlayer();
		SeekBar seekbarProgress;
		public int oneTimeOnly = 0;
		private final Handler handler = new Handler();
		private double timeElapsed = 0, finalTime = 0;

		private Map<String, List<String>> ParentListItems;
		private List<String> Items;

		public T410(Activity context, List<String> Items,
				Map<String, List<String>> ParentListItems) {
			this.context = context;
			this.ParentListItems = ParentListItems;
			this.Items = Items;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return ParentListItems.get(Items.get(groupPosition)).get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(final int groupPosition, final int childPosition,
				boolean isLastChild, View ListView, ViewGroup parent) {
			final String child = (String) getChild(groupPosition, childPosition);
			LayoutInflater inflater = context.getLayoutInflater();
			if (ListView == null) {
				ListView = inflater.inflate(R.layout.child_list_item2, null);

			}
			TextView item = (TextView) ListView.findViewById(R.id.textView2);
			item.setText(child);
			Typeface face1 = Typeface.createFromAsset(context.getAssets(),
					"fonts/gfzemenu.ttf");
			item.setTypeface(face1);
			mp = new MediaPlayer();
			play = (Button) ListView.findViewById(R.id.play);
			play.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					final Dialog dialog = new Dialog(context);
					dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					dialog.setContentView(R.layout.popup_player);
					dialog.getWindow().setGravity(Gravity.BOTTOM);
					dialog.getWindow().setBackgroundDrawable(
							new ColorDrawable(Color.TRANSPARENT));

					playpause = (Button) dialog.findViewById(R.id.playpause);
					seekbarProgress = (SeekBar) dialog.findViewById(R.id.seekBar);
					duratio = (TextView) dialog.findViewById(R.id.songDuration);
					seekbarProgress.setVisibility(View.GONE);
					duratio.setVisibility(View.GONE);
					seekbarProgress.setProgress(0);
					seekbarProgress.setMax(100);
					dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

						@Override
						public void onDismiss(DialogInterface arg0) {
							// TODO Auto-generated method stub
							mp.pause();
							mp.release();
							mp = new MediaPlayer();
							playpause
									.setBackgroundResource(drawable.ic_media_play);

							play.setBackgroundResource(drawable.ic_media_play);
						}
					});
					playpause.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							try {
								data(childPosition, groupPosition);

							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					});
					seekbarProgress
							.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

								@Override
								public void onStopTrackingTouch(SeekBar seek) {
									if (mp != null && mp.isPlaying()) {
										mp.seekTo(seek.getProgress());
									}
								}

								@Override
								public void onStartTrackingTouch(SeekBar arg0) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onProgressChanged(SeekBar seekBar,
										int progress, boolean fromTouch) {

								}
							});

					dialog.show();
				}
			});

			return ListView;
		}

		@Override
		public void onGroupCollapsed(int groupPosition) {
			super.onGroupCollapsed(groupPosition);
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return ParentListItems.get(Items.get(groupPosition)).size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return Items.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return Items.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View ListView, ViewGroup parent) {
			String CoursesFull = (String) getGroup(groupPosition);
			if (ListView == null) {
				LayoutInflater infalInflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ListView = infalInflater.inflate(R.layout.parent_list_item2, null);
			}
			TextView item = (TextView) ListView.findViewById(R.id.textView2);
			item.setText(CoursesFull);
			Typeface face = Typeface.createFromAsset(context.getAssets(),
					"fonts/gfzemenu.ttf");
			item.setTypeface(face);

			return ListView;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

		public void data(int childPosition, int groupPosition) {
			if (childPosition == 0 && groupPosition == 0) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/181.Nefse hoy.mp3");
			} else if (childPosition == 0 && groupPosition == 1) {

				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/182.Be Hiwote bezemene.mp3");
			} else if (childPosition == 0 && groupPosition == 2) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/183.Yesew lij behaylih.mp3");
			} else if (childPosition == 0 && groupPosition == 3) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/184.Amlakehen weded.mp3");
			} else if (childPosition == 0 && groupPosition == 4) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/185.Fetarihen aseb part 1.mp3");
			} else if (childPosition == 0 && groupPosition == 5) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/186.Aytewegnim.mp3");
			} else if (childPosition == 0 && groupPosition == 6) {
				mezmurPlay(Environment.getExternalStorageDirectory().getPath()
						+ "/mez/Tiraz4/187.Erdagn zim atibel.mp3");
			} 
		}

		private void mezmurPlay(String path) {
			File file = new File(path);
			if (!file.exists()) {
				Toast.makeText(context,
						"መዝሙሩ ስልክዎ ውስጥ የለም! እባክዎ 'እርዳታ' ወደ ሚለው ገጽ ይሒዱ!",
						Toast.LENGTH_SHORT).show();
			}
			try {
				mp.reset();
				mp.setDataSource(path);
				mp.prepare();
				mp.setVolume(1f, 1f);
				mp.start();
				finalTime = mp.getDuration();
				timeElapsed = mp.getCurrentPosition();

				if (oneTimeOnly == 0) {
					seekbarProgress.setMax((int) finalTime);
					oneTimeOnly = 0;
				}

				duratio.setText(String.format(
						"%d min, %d sec",
						TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed),
						TimeUnit.MILLISECONDS.toSeconds((long) timeElapsed)
								- TimeUnit.MINUTES
										.toSeconds(TimeUnit.MILLISECONDS
												.toMinutes((long) timeElapsed))));

				seekbarProgress.setProgress((int) timeElapsed);
				handler.postDelayed(UpdateSongTime, 100);
				seekbarProgress.setVisibility(View.VISIBLE);
				duratio.setVisibility(View.VISIBLE);
				playpause.setBackgroundResource(drawable.ic_media_pause);
				play.setBackgroundResource(drawable.ic_media_pause);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		private Runnable UpdateSongTime = new Runnable() {
			public void run() {
				timeElapsed = mp.getCurrentPosition();
				duratio.setText(String.format(
						"%d min, %d sec",
						TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed),
						TimeUnit.MILLISECONDS.toSeconds((long) timeElapsed)
								- TimeUnit.MINUTES
										.toSeconds(TimeUnit.MILLISECONDS
												.toMinutes((long) timeElapsed))));
				seekbarProgress.setProgress((int) timeElapsed);
				handler.postDelayed(this, 100);
			}
		};
}
}