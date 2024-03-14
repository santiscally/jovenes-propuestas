import { extendBaseTheme, theme as chakraTheme } from "@chakra-ui/react";

const components = chakraTheme.components;
const colors = {
  brand: {
    100: "#f9f7f3",
    200: "#a0c1b9",
    300: "#588157",
    400: "#3A5A40",
    500: "#344E41",
    600: "#504b43",
    700: "#080706",
  },
};

export const theme = extendBaseTheme({
  components,
  colors,
});
