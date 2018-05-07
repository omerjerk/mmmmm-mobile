import xs, {Stream} from 'xstream';
import {ScreensSource, ScreenVNode} from 'cycle-native-navigation';
import {h} from '@cycle/native-screen';
import {Palette} from '../../../global-styles/palette';
import {Screens} from '../../..';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import { IconButtonProps } from 'react-native-vector-icons/Icon';
import { DocumentPicker } from 'react-native-document-picker';
import { Dimensions } from '../../../global-styles/dimens';

export type Sources = {
  screen: ScreensSource;
};
  
export type Sinks = {
  screen: Stream<ScreenVNode>;
};

// function intent(source: ScreensSource): Stream<any> {
    // return source.select('composeAttachButton').events('press');
// }
  
function view() {
  return xs.of({
    screen: Screens.ComposeAttachButton,
    vdom: h(Icon, {
      selector: "composeAttachButton",
      size: Dimensions.iconSizeNormal,
      color: Palette.brand.darkTextWeak,
      name: 'attachment',
      style: {
        alignSelf: "center"
      },
      onPress(event) {
        DocumentPicker.show({
          filetype: ["image/*"]
        }, (error, res) => {
          console.log(res.fileName)
          console.log(res.uri)
        })
      }
    } as IconButtonProps),
  });
}

export default function attachButton(sources: Sources): Sinks {
  // const click$ = intent(sources.screen);
  const vdom$ = view();

  return {
    screen: vdom$
  };
}


