import { Box, Flex } from "@chakra-ui/react";

const Home = () => {
  return (
    <div>
      <Flex w={"100%"} h={"500px"}>
        <Box w={"20%"} bg={"#f9f7f3"} h={"100%"}></Box>
        <Box w={"20%"} bg={"#a0c1b9"} h={"100%"}></Box>
        <Box w={"20%"} bg={"#588157"} h={"100%"}></Box>
        <Box w={"20%"} bg={"#3A5A40"} h={"100%"}></Box>
        <Box w={"20%"} bg={"#344E41"} h={"100%"}></Box>
        <Box w={"20%"} bg={"#504b43"} h={"100%"}></Box>
      </Flex>
    </div>
  );
};

export default Home;
